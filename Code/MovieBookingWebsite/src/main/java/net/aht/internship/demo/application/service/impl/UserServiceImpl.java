package net.aht.internship.demo.application.service.impl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.aht.internship.demo.application.constants.CommonConstant;
import net.aht.internship.demo.application.constants.DevMessageConstant;
import net.aht.internship.demo.application.jwt.JwtUtils;
import net.aht.internship.demo.application.repository.IRoleRepository;
import net.aht.internship.demo.application.repository.IUserRepository;
import net.aht.internship.demo.application.request.LoginRequest;
import net.aht.internship.demo.application.response.UserResponse;
import net.aht.internship.demo.application.service.FileUpload;
import net.aht.internship.demo.application.service.IUserService;
import net.aht.internship.demo.application.service.user_detail.UserDetailImpl;
import net.aht.internship.demo.config.exception.VsException;
import net.aht.internship.demo.domain.dto.UserDTO;
import net.aht.internship.demo.domain.dto.UserSearchDTO;
import net.aht.internship.demo.domain.entity.Role;
import net.aht.internship.demo.domain.entity.User;
import net.aht.internship.demo.domain.mapper.UserMapper;
import net.aht.internship.demo.domain.pagine.PaginateDTO;
import net.sf.jasperreports.engine.JRException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class UserServiceImpl implements IUserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserMapper userMapper;
    private final FileUpload fileUpload;

    public UserServiceImpl(IUserRepository userRepository,
                           IRoleRepository roleRepository,
                           AuthenticationManager authenticationManager,
                           JwtUtils jwtUtils, UserMapper userMapper,
                           FileUpload fileUpload) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.userMapper = userMapper;
        this.fileUpload = fileUpload;
    }

    @Override
    public User createUser(UserDTO accountDTO,
                           HttpServletRequest request) {
        if (userRepository.existsByUsername(accountDTO.getUsername())) {
            throw new VsException(String.format(
                    DevMessageConstant.Common.EXITS_USERNAME,
                    accountDTO.getUsername()));
        }
        String createdBy = "";
        String updatedBy = "";
        String auth = request.getHeader("Authorization");
        boolean isCreatedByAdmin = false;
        boolean isCreatedByManager = false;
        if (auth != null && auth.startsWith("Bearer ")) {
            User currentUser = userRepository.findByUsername(
                    jwtUtils.getUserByToken(auth.substring(7)));
            Collection<Role> roles = currentUser.getRoles();
            if (roles.iterator().next().getRoleName().equalsIgnoreCase("ROLE_ADMIN")) {
                createdBy = currentUser.getUsername();
                updatedBy = createdBy;
                isCreatedByAdmin = true;
            } else if (roles.iterator().next().getRoleName().equalsIgnoreCase("ROLE_MANAGER")) {
                createdBy = currentUser.getUsername();
                updatedBy = createdBy;
                isCreatedByManager = true;
            }
        }
        try {
            User account = userMapper.mapDTOToEntity(accountDTO);
            account.setUsername(accountDTO.getUsername());
            log.info(accountDTO.getUsername());
            account.setEmail(accountDTO.getEmail());
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(
                    CommonConstant.FORMAT_DATE_PATTERN);
            LocalDateTime currentDate = LocalDateTime.now();
            currentDate.format(dtf);
            account.setCreatedAt(Timestamp.valueOf(currentDate));
            account.setCreatedBy(createdBy);
            account.setUpdatedAt(Timestamp.valueOf(currentDate));
            account.setUpdatedBy(createdBy);
            account.setActiveFlag(true);
            account.setDeleteFlag(false);
            account.setLogInCount((long) 0);
            account.setTotalSpent(BigDecimal.ZERO);
//            account.setAvatar(fileUpload.uploadFile(accountDTO.getAvatar()));
            account.setPassword(new BCryptPasswordEncoder().encode(
                    accountDTO.getPassword()));

            Set<Role> roles = new HashSet<>();
            // Nếu là người dùng đầu tiên thì sẽ là admin có full chức năng
            if (userRepository.findAll().isEmpty()) {
                roles.add(roleRepository.findByRoleName("ROLE_ADMIN"));
                roles.add(roleRepository.findByRoleName("ROLE_MANAGER"));
                roles.add(roleRepository.findByRoleName("ROLE_EMPLOYEE"));
                roles.add(roleRepository.findByRoleName("ROLE_USER"));
            } else {
                // nếu được tạo bởi 1 người có quyền admin
                // account được tạo sẽ là của manager và có full quyền trừ admin
                if (isCreatedByAdmin) {
                    roles.add(roleRepository.findByRoleName("ROLE_MANAGER"));
                    roles.add(roleRepository.findByRoleName("ROLE_EMPLOYEE"));
                    roles.add(roleRepository.findByRoleName("ROLE_USER"));
                }
                // nếu được tạo bởi 1 người có quyền manager
                // account được tạo sẽ là của employee và có full quyền trừ admin
                // và manager
                else if (isCreatedByManager) {
                    roles.add(roleRepository.findByRoleName("ROLE_EMPLOYEE"));
                    roles.add(roleRepository.findByRoleName("ROLE_USER"));
                }
                // nếu không phải 2 trường hợp trên thì sẽ là đăng ký
                // người dùng được tạo sẽ chỉ có quyền user cơ bản
                else {
                    roles.add(roleRepository.findByRoleName("ROLE_USER"));
                }
            }
            account.setRoles(roles);
            userRepository.save(account);
            account.setCode(generateUserCode(account));

            return userRepository.save(account);

        } catch (Exception ex) {
            throw new VsException(String.format(DevMessageConstant.Common.REGISTER_FAILED, ex));
        }

    }

    @Override
    public UserResponse login(LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetailImpl userDetail = (UserDetailImpl) authentication.getPrincipal();
            String accessToken = jwtUtils.generateTokenByUsername(userDetail.getUsername());
            List<String> role = userDetail.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
            return new UserResponse(
                    userDetail.getUser().getId(),
                    userDetail.getUser().getFullName(),
                    userDetail.getUser().getEmail(),
                    userDetail.getUser().getGender(),
                    accessToken, role

            );
        } catch (BadCredentialsException ex) {
            SecurityContextHolder.clearContext();
            throw new VsException(DevMessageConstant.Common.LOGIN_FAIL);
        }
    }

    private String generateUserCode(User user) {
        List<Role> userRoles = user.getRoles().stream().toList();
        Role userRole = userRoles.get(0);
        String[] yearAndMonth = user.getCreatedAt().toString().split("-");

        if (userRole.getRoleName().equals("ROLE_ADMIN")) {
            return yearAndMonth[0].substring(2, 4) + yearAndMonth[1] + String.valueOf('A') + user.getId().toString();
        }
        if (userRole.getRoleName().equals("ROLE_MANAGER")) {
            return yearAndMonth[0].substring(2, 4) + yearAndMonth[1] + String.valueOf('M') + user.getId().toString();
        }
        if (userRole.getRoleName().equals("ROLE_EMPLOYEE")) {
            return yearAndMonth[0].substring(2, 4) + yearAndMonth[1] + String.valueOf('E') + user.getId().toString();
        } else {
            return yearAndMonth[0].substring(2, 4) + yearAndMonth[1] + String.valueOf('U') + user.getId().toString();
        }

    }

    @Override
    public PaginateDTO<User> getAllUsers(Integer page, Integer size) {
        return new PaginateDTO<>(userRepository.findAll(PageRequest.of(page, size, Sort.by("").descending())).getContent(), page, size);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (ObjectUtils.isEmpty(user)) {
            throw new VsException(String.format(DevMessageConstant.Common.OBJECT_NOT_FOUND,
                    User.class.getName(), userId));
        }
        return user.get();
    }

    @Override
    public User findUserByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }


    @Override
    public User updateUser(Long userId,
                           UserDTO userDTO,
                           HttpServletRequest request) {
        if (userId != null) {
            // tìm user theo id
            User existedUser = findUserById(userId);
            if (!ObjectUtils.isEmpty(existedUser)) {
                // Lấy tên của quản trị viên hiện tại
                // và gán vào createdBy và updatedBy
                String auth = request.getHeader("Authorization");
                String updatedBy = "";
                boolean isCreatedByAdmin = false;
                boolean isCreatedByManager = false;
                if (auth != null && jwtUtils.validationToken(auth.substring(7))) {
                    User currentUser = userRepository.findByUsername(jwtUtils.getUserByToken(auth.substring(7)));
                    Collection<Role> roles = currentUser.getRoles();
                    if (roles.iterator().next().getRoleName().equalsIgnoreCase("ROLE_ADMIN")) {
                        updatedBy = currentUser.getFullName();
                        isCreatedByAdmin = true;
                    } else if (roles.iterator().next().getRoleName().equalsIgnoreCase("ROLE_MANAGER")) {
                        updatedBy = currentUser.getFullName();
                        isCreatedByManager = true;
                    }
                }
            }
            return userRepository.save(existedUser);
        }
        return null;
    }

    @Override
    public String deleteUser(Long userId) {
        userRepository.deleteById(userId);
        return "Deleted succesfully";
    }

    @Override
    public String setUserActiveFlag(Long userId, boolean flag) {
        return "";
    }


    @Override
    public Long countUser() {
        return null;
    }

    @Override
    public Page<User> searchUsers(UserSearchDTO search, Pageable pageable) {
        return null;
    }

    @Override
    public String exportReport(String reportFomat, User currentUser) throws FileNotFoundException, JRException {
        return "";
    }

    @Override
    public String logout(Authentication authentication, HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
        logoutHandler.logout(request, response, authentication);
        return DevMessageConstant.Common.LOGOUT;
    }
}

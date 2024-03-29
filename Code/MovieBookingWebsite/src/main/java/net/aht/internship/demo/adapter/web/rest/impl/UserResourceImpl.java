package net.aht.internship.demo.adapter.web.rest.impl;

import com.cloudinary.Cloudinary;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.aht.internship.demo.adapter.web.base.RestApiV1;
import net.aht.internship.demo.adapter.web.base.VsResponseUtil;
import net.aht.internship.demo.adapter.web.rest.UserResource;
import net.aht.internship.demo.application.jwt.JwtUtils;
import net.aht.internship.demo.application.request.LoginRequest;
import net.aht.internship.demo.application.service.IUserService;
import net.aht.internship.demo.domain.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

@RestApiV1
public class UserResourceImpl implements UserResource {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    Cloudinary cloudinary;
    private IUserService userService;

    public UserResourceImpl(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<?> searchAll(Integer page, Integer size) {
        return VsResponseUtil.ok(userService.getAllUsers(page, size));
    }

    @Override
    public ResponseEntity<?> getAll() {
        return VsResponseUtil.ok(userService.getAllUsers());
    }

    @Override
    public ResponseEntity<?> getAllUsers() {
        return VsResponseUtil.ok(userService.getAllUsers());
    }

    @Override
    public ResponseEntity<?> login(LoginRequest loginRequest) {
        return VsResponseUtil.ok(userService.login(loginRequest));
    }

    @Override
    public ResponseEntity<?> register(UserDTO userDTO,
                                      HttpServletRequest request) {
        return VsResponseUtil.ok(userService.createUser(userDTO, request));
    }

    @Override
    public ResponseEntity<?> logout(Authentication authentication, HttpServletRequest request, HttpServletResponse response) {
        return VsResponseUtil.ok(userService.logout(authentication, request, response));
    }

    @Override
    public ResponseEntity<?> createAccountByAdmin(UserDTO userDTO,
//                                                  MultipartFile avatar,
                                                  HttpServletRequest request) {
        return VsResponseUtil.ok(userService.createUser(userDTO, request));
    }

    @Override
    public ResponseEntity<?> getAccountById(Long userId) {
        return VsResponseUtil.ok(userService.findUserById(userId));
    }

    @Override
    public ResponseEntity<?> updateAccountByAdmin(Long userId,
                                                  UserDTO userDTO,
//                                                  MultipartFile avatar,
                                                  HttpServletRequest request) {
//        userDTO.setAvatar(avatar);
        return VsResponseUtil.ok(userService.updateUser(userId, userDTO, request));
    }

    @Override
    public ResponseEntity<?> deleteAccountByAdmin(Long userId) {
        return VsResponseUtil.ok(userService.deleteUser(userId));
    }


}

package net.aht.internship.demo.application.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.aht.internship.demo.application.request.LoginRequest;
import net.aht.internship.demo.application.response.UserResponse;
import net.aht.internship.demo.domain.dto.UserDTO;
import net.aht.internship.demo.domain.dto.UserSearchDTO;
import net.aht.internship.demo.domain.entity.User;
import net.aht.internship.demo.domain.pagine.PaginateDTO;
import net.sf.jasperreports.engine.JRException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;

import java.io.FileNotFoundException;
import java.util.List;

public interface IUserService {

    User createUser(UserDTO accountDTO, HttpServletRequest request);

    UserResponse login(LoginRequest loginRequest);

    PaginateDTO<User> getAllUsers(Integer page, Integer size);

    List<User> getAllUsers();

    User findUserById(Long userId);

    User findUserByUsername(String userEmail);

    User updateUser(Long userId, UserDTO accouUserDTO, HttpServletRequest request);

    String deleteUser(Long userId);

    String setUserActiveFlag(Long userId, boolean flag);

    Long countUser();

    Page<User> searchUsers(UserSearchDTO search, Pageable pageable);

    String exportReport(String reportFomat, User currentUser) throws FileNotFoundException, JRException;

    String logout(Authentication authentication, HttpServletRequest request, HttpServletResponse response);
}

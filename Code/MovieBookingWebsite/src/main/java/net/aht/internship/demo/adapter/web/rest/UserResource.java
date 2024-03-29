package net.aht.internship.demo.adapter.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.aht.internship.demo.application.request.LoginRequest;
import net.aht.internship.demo.domain.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Validated
@Api(tags = "Users Resource")
public interface UserResource {

    @ApiOperation(value = "Find all users")
    @GetMapping("/ad/um/find-all")
    ResponseEntity<?> searchAll(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                @RequestParam(name = "size", required = false, defaultValue = "5") Integer size);


    @ApiOperation(value = "get all users")
    @GetMapping("/ad/um/get-all")
    ResponseEntity<?> getAll();

    @ApiOperation(value = "get all users")
    @GetMapping("/no-auth/get-all")
    ResponseEntity<?> getAllUsers();

    @ApiOperation(value = "Login - Both")
    @PostMapping("/no-auth/login")
    ResponseEntity<?> login(@RequestBody LoginRequest loginRequest);

    @ApiOperation("Register - Both")
    @PostMapping(value = "no-auth/register", consumes = {"multipart/form-data"})
    ResponseEntity<?> register(@RequestBody UserDTO userDTO,
                               HttpServletRequest request);

    @ApiOperation("Logout - Both")
    @GetMapping("/all/logout")
    ResponseEntity<?> logout(Authentication authentication,
                             HttpServletRequest request,
                             HttpServletResponse response);

    @ApiOperation("Create user - Admin")
    @PostMapping("/ad/um/create")
    ResponseEntity<?> createAccountByAdmin(@ModelAttribute UserDTO userDTO,
//                                           @RequestParam(name = "avatar") MultipartFile avatar,
                                           HttpServletRequest request) throws IOException;

    @ApiOperation("Get user by id - Admin")
    @GetMapping(value = "/ad/um/get/{userId}")
    ResponseEntity<?> getAccountById(@PathVariable("userId") Long userId);

    @ApiOperation("Update user by id - Admin")
    @PostMapping("/ad/um/edit/{userId}")
    ResponseEntity<?> updateAccountByAdmin(@PathVariable("userId") Long userId,
                                           @RequestBody UserDTO userDTO,
//                                           @RequestParam(name = "avatar") MultipartFile avatar,
                                           HttpServletRequest request) throws IOException;

    @ApiOperation("Delete user by id - Admin")
    @PostMapping("/ad/um/delete/{userId}")
    ResponseEntity<?> deleteAccountByAdmin(@PathVariable("userId") Long userId);
}

package net.aht.internship.demo.application.response;

import java.util.List;

public class UserResponse {

    private Long id;
    private String fullName;
    private String email;
    private String gender;
    private String accessToken;
    private List<String> role;

    public UserResponse() {
    }

    public UserResponse(Long id, String fullName, String email, String gender, String accessToken, List<String> role) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.gender = gender;
        this.accessToken = accessToken;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }
}

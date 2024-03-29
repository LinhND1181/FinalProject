package net.aht.internship.demo.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tbluser")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User extends AbstractBase {

    @NotEmpty(message = "Username must not be empty")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "user_username", nullable = false)
    private String username;

    @NotEmpty(message = "Email must not be empty")
    @JsonInclude(JsonInclude.Include.NON_NULL)
//	@Pattern(regexp = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Email is not format")
    @Column(name = "user_email", nullable = false)
    private String email;

    @NotEmpty(message = "Password must not be empty")
//	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+-=\\[\\]{};:'\"<>,.?/]).{8,}$", message = "Password is not valid")
    @Column(name = "user_password", nullable = false)
    @JsonIgnore
    private String password;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "user_fullname")
    private String fullName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    @Column(name = "user_dob")
    private Timestamp birthday;

    @Column(name = "user_gender")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String gender;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "user_address")
    private String address;

    //    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 characters")
    @Column(name = "user_phonenumber")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String phoneNumber;

    @Column(name = "user_avatar")
    private String avatar;

    @Column(name = "user_code")
    private String code;

    @Column(name = "user_logincount")
    private Long logInCount;

    @Column(name = "user_totalspend")
    private BigDecimal totalSpent;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tbluser_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonIgnoreProperties("users")
    private Collection<Role> roles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(fullName, user.fullName) && Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) && Objects.equals(email, user.email) &&
                Objects.equals(birthday, user.birthday) && Objects.equals(gender, user.gender) &&
                Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(address, user.address) &&
                Objects.equals(code, user.code) && Objects.equals(logInCount, user.logInCount) && Objects.equals(totalSpent, user.totalSpent) &&
                Objects.equals(avatar, user.avatar) && Objects.equals(user.getRoles(), user.getRoles());
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, username, password, email, birthday, gender, phoneNumber, address, avatar, code, logInCount, totalSpent, roles);
    }

}

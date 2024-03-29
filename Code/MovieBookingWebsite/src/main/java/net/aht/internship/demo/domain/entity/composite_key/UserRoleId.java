package net.aht.internship.demo.domain.entity.composite_key;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleId implements Serializable {

    private Long user;
    private Long role;

    public void setUser(Long user) {
        this.user = user;
    }

    public void setRole(Long role) {
        this.role = role;
    }
}

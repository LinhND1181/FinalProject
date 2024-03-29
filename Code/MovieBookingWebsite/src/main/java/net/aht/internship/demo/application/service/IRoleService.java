package net.aht.internship.demo.application.service;

import net.aht.internship.demo.domain.entity.Role;

import java.util.List;

public interface IRoleService {

    Role createRole(Role role);

    Role getRoleById(Long roleId);

    List<Role> getAllRoles();

    void deleteRole(Long roleId);

}

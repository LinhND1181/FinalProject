package net.aht.internship.demo.application.repository;

import net.aht.internship.demo.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Long> {

    Role findByRoleName(String roleName);

}

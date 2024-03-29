package net.aht.internship.demo.application.repository;

import net.aht.internship.demo.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {

    Page<User> findByFullNameContaining(String keyword, Pageable pageable);

    Page<User> findByActiveFlagAndFullNameContainingOrderByCreatedAtDesc(boolean status, String keyword,
                                                                         Pageable pageable);

    Page<User> findByActiveFlagOrderByCreatedAtDesc(boolean status, Pageable pageable);

    Optional<User> findByEmail(String email);

    boolean existsByUsername(String userName);

    User findByUsername(String userName);
}

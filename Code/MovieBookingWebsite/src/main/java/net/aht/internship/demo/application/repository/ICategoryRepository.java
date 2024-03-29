package net.aht.internship.demo.application.repository;

import net.aht.internship.demo.domain.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICategoryRepository extends JpaRepository<Category, Long> {

    Page<Category> findAll(Pageable pageable);

    Page<Category> findByActiveFlagAndNameContainingOrderByCreatedAtDesc(boolean status, String keyword,
                                                                         Pageable pageable);

    Page<Category> findByActiveFlagOrderByCreatedAtDesc(boolean status, Pageable pageable);

    Optional<Category> findByName(String cityName);

    Optional<Category> findById(Category updatedCategory);

    Page<Category> findByNameContaining(String keyword, Pageable pageable);

}

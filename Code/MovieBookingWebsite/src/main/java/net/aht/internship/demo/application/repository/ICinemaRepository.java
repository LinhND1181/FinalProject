package net.aht.internship.demo.application.repository;

import net.aht.internship.demo.domain.entity.Cinema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICinemaRepository extends JpaRepository<Cinema, Long> {

    Page<Cinema> findAll(Pageable pageable);

    Page<Cinema> findByActiveFlagAndNameContainingOrderByCreatedAtDesc(boolean status, String keyword,
                                                                             Pageable pageable);

    Page<Cinema> findByActiveFlagOrderByCreatedAtDesc(boolean status, Pageable pageable);

    Optional<Cinema> findByName(String CinemaName);

    Optional<Cinema> findById(Cinema updatedCinema);

    Page<Cinema> findByNameContaining(String keyword, Pageable pageable);

}

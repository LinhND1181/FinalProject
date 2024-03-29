package net.aht.internship.demo.application.repository;

import net.aht.internship.demo.domain.entity.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICityRepository extends JpaRepository<City, Long> {

    Page<City> findAll(Pageable pageable);

    Page<City> findByActiveFlagAndCityNameContainingOrderByCreatedAtDesc(boolean status, String keyword,
                                                                         Pageable pageable);

    Page<City> findByActiveFlagOrderByCreatedAtDesc(boolean status, Pageable pageable);

    Optional<City> findByCityName(String cityName);

    Optional<City> findById(City updatedCity);

    Page<City> findByCityNameContaining(String keyword, Pageable pageable);

}

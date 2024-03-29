package net.aht.internship.demo.application.service;

import net.aht.internship.demo.domain.dto.UserSearchDTO;
import net.aht.internship.demo.domain.entity.Cinema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICinemaService {

    Page<Cinema> getAllCinemas(Pageable pageable);

    List<Cinema> getAllCinemas();

    Cinema getCinemaById(Long CinemaId);

    Cinema getCinemaByName(String CinemaName);

    void addCinema(Cinema newCinema);

    void updateCinema(Cinema updatedCinema);

    void deleteCinema(Long CinemaId);

    void setCinemaActiveFlag(Long CinemaId, boolean activeFlag);

    Page<Cinema> searchCinemas(UserSearchDTO userSearchDTO, Pageable pageable);

}

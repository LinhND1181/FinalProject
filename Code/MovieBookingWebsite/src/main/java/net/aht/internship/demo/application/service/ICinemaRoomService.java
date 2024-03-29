package net.aht.internship.demo.application.service;

import net.aht.internship.demo.domain.dto.UserSearchDTO;
import net.aht.internship.demo.domain.entity.CinemaRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICinemaRoomService {

    Page<CinemaRoom> getAllCinemaRooms(Pageable pageable);

    List<CinemaRoom> getAllCinemaRooms();

    CinemaRoom getCinemaRoomById(Long cinemaRoomId);

    CinemaRoom getCinemaRoomByName(String cinemaRoomName);

    void addCinemaRoom(CinemaRoom newCinemaRoom);

    void updateCinemaRoom(CinemaRoom updatedCinema);

    void deleteCinemaRoom(Long cinemaRoomId);

    void setCinemaRoomActiveFlag(Long cinemaRoomId, boolean activeFlag);

    Page<CinemaRoom> searchCinemaRooms(UserSearchDTO userSearchDTO, Pageable pageable);

    Page<CinemaRoom> getAllCinemaRoomsByCinemaId(Long cinemaId, UserSearchDTO userSearchDTO, Pageable page);

}

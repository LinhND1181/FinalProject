package net.aht.internship.demo.application.repository;

import net.aht.internship.demo.domain.entity.RoomSeat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoomSeatRepository extends JpaRepository<RoomSeat, Long> {

    Page<RoomSeat> findAll(Pageable pageable);

    Page<RoomSeat> findByActiveFlagAndCodeContainingOrderByCreatedAtDesc(boolean status, String keyword,
                                                                         Pageable pageable);

    Page<RoomSeat> findByActiveFlagOrderByCreatedAtDesc(boolean status, Pageable pageable);

    Optional<RoomSeat> findByPosition(String cinema_RoomName);

    Optional<RoomSeat> findById(RoomSeat updatedCinema_Room);

    Page<RoomSeat> findByCodeContaining(String keyword, Pageable pageable);

    Page<RoomSeat> findAllByCinemaRoomId(Pageable pageable, Long cinemaId);

    Page<RoomSeat> findByCinemaRoomIdAndCodeContaining(Long cinemaId, String keyword, Pageable page);

    Page<RoomSeat> findByCinemaRoomIdAndActiveFlagAndCodeContainingOrderByCreatedAtDesc(Long cinemaId, boolean b,
                                                                                        String keyword, Pageable page);

    RoomSeat findByCode(String code);

}

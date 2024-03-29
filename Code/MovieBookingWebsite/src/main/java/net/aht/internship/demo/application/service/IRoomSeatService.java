package net.aht.internship.demo.application.service;

import net.aht.internship.demo.domain.dto.UserSearchDTO;
import net.aht.internship.demo.domain.entity.RoomSeat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IRoomSeatService {
    Page<RoomSeat> getAllRoomSeats(Pageable pageable);

    List<RoomSeat> getAllRoomSeats();

    RoomSeat getRoomSeatById(Long roomSeatId);

    RoomSeat getRoomSeatByPosition(String roomSeatName);

    void addRoomSeat(RoomSeat newRoomSeat);

    void updateRoomSeat(RoomSeat updatedRoomSeat);

    void deleteRoomSeat(Long roomSeatId);

    void setRoomSeatActiveFlag(Long roomSeatId, boolean activeFlag);

    Page<RoomSeat> searchRoomSeats(UserSearchDTO userSearchDTO, Pageable pageable);

    Page<RoomSeat> getAllRoomSeatsByCinemaRoomId(Long cinemaRoomId, UserSearchDTO userSearchDTO, Pageable page);

    RoomSeat getRoomSeatByCode(String code);
}

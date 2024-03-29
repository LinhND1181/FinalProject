package net.aht.internship.demo.domain.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CinemaRoomDTO {

    private String description;

    private String name;

    private String phoneNumber;

    private Long cinemaId;

    private List<RoomSeatDTO> roomSeats = new ArrayList<>();

}

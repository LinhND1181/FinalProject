package net.aht.internship.demo.domain.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cinema {

    private String location;

    private String name;

    private int totalRoom;

    private List<CinemaRoomDTO> cinemaRooms = new ArrayList<>();

}

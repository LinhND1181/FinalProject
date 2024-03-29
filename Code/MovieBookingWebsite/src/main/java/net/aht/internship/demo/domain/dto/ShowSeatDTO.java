package net.aht.internship.demo.domain.dto;

import lombok.Data;

@Data
public class ShowSeatDTO {

    private Boolean isAvailable = Boolean.TRUE;

    private double price;

    private String roomSeat;

    private String showName;

}

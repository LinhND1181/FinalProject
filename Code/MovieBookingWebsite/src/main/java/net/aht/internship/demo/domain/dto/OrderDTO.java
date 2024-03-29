package net.aht.internship.demo.domain.dto;

import lombok.Data;

@Data
public class OrderDTO {

    private int numberOfCombos;

    private String status;

    private String paymentMethod;

    private UserDTO user;

}

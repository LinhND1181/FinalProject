package net.aht.internship.demo.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class ComboDTO {

    private String name;

    private double price;

    private String thumbnail;

    private List<OrderDetailComboDTO> orderDetailCombos;

}

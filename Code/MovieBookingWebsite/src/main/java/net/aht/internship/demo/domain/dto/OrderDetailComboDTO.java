package net.aht.internship.demo.domain.dto;

import lombok.Data;

@Data
public class OrderDetailComboDTO {

    private int comboQuantity;

    private Long comboId;

    private Long orderId;

}

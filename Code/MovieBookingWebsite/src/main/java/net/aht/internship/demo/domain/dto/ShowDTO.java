package net.aht.internship.demo.domain.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ShowDTO {

    private Date startedTime;

    private Date endedTime;

    private Boolean isFull = Boolean.FALSE;

    private String roomName;

    private String filmName;

}

package net.aht.internship.demo.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tblbooking")
public class Booking extends AbstractBase {

    private static final long serialVersionUID = 1L;

    @Column(name = "booking_status")
    private String status;

    @Column(name = "booking_is_cancel")
    private boolean isCancel;

    @Column(name = "booking_number_of_seats")
    private int numberOfSeats;

    @ManyToOne
    @JoinColumn(name = "booking_show_id")
    private Show show;

    @ManyToOne
    @JoinColumn(name = "booking_order_id")
    private Order order;
}

package net.aht.internship.demo.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tblss") // ss is show_seats
public class ShowSeat extends AbstractBase {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Show_seats's price must not be blank")
    @Column(name = "ss_price")
    private double price;

    @NotBlank(message = "Show_seats must be available or not")
    @Column(name = "ss_is_available")
    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "room_seat_id")
    private RoomSeat roomSeat;

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

}

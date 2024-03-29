package net.aht.internship.demo.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tblseat") // rs is room seats
public class RoomSeat extends AbstractBase {

    @Column(name = "seat_type")
    private String type;

    @Column(name = "seat_position")
    private String position;

    @Column(name = "seat_row")
    private Character row;

    @Column(name = "seat_column")
    private Integer column;

    @Column(name = "seat_code")
    private String code;

    @Column(name = "seat_status")
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "seat_cinema_room_id")
    private CinemaRoom cinemaRoom;

    @JsonIgnore
    @OneToMany(mappedBy = "roomSeat", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToStringExclude
    private Collection<ShowSeat> showSeats;

}

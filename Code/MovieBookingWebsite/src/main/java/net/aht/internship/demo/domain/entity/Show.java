package net.aht.internship.demo.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tblshow")
public class Show extends AbstractBase {

    @ManyToOne
    @JoinColumn(name = "room_id")
    private CinemaRoom cinemaRoom;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @Column(name = "show_start_time")
    private LocalDateTime startTime;

    @Column(name = "show_end_time")
    private LocalDateTime endTime;

    @Column(name = "show_is_full")
    private Boolean isFull;

    @Column(name = "show_code")
    private String code;

    @JsonIgnore
    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToStringExclude
    private Collection<ShowSeat> show_Seats;
}

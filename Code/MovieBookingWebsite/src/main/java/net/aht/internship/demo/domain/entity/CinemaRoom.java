package net.aht.internship.demo.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tblcr") // cr is cinemaroom
public class CinemaRoom extends AbstractBase {

    @Column(name = "cr_name", unique = true)
    @NotBlank(message = "Room's name can't be blank")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "cinemaRoom", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<RoomSeat> roomSeats;

    @JsonIgnore
    @OneToMany(mappedBy  = "cinemaRoom", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToStringExclude
    private Collection<Show> shows;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;

    @Column(name = "cr_code")
    private String code;

    @Column(name = "cr_status")
    private String status;

}

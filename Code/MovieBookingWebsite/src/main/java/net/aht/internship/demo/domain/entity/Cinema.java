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
@Table(name = "tblcinema")
public class Cinema extends AbstractBase {

    @Column(name = "cinema_name", unique = true)
    private String name;

    @Column(name = "cinema_location")
    private String location;

    @Column(name = "cinema_phone_number")
    private String phoneNumber;

    @Column(name = "cinema_description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "cinema_code")
    private String code;

    @Column(name = "cinema_revenue")
    private String revenue;

    @Column(name = "cinema_owner")
    private String owner;

    @JsonIgnore
    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToStringExclude
    private Collection<CinemaRoom> cinemaRooms;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cinema_city_id")
    private City city;

}

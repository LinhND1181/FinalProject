package net.aht.internship.demo.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tblcombo")
public class Combo extends AbstractBase {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Combo's name must not be blank")
    @Column(name = "combo_name")
    private String name;

    @NotBlank(message = "Combo's price must not be blank")
    @Column(name = "combo_price")
    private double price;

    @OneToMany(mappedBy = "combo", cascade = CascadeType.ALL)
    private List<Media> mediaList;

}

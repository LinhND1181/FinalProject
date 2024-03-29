package net.aht.internship.demo.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tblfilm")
public class Film extends AbstractBase {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Film's name must not be blank")
    @Column(name = "name", unique = true)
    private String name;

    @NotBlank(message = "Film's length must not be blank")
    @Column(name = "length")
    private String length;

    @Column(name = "started_date")
    private Date startedDate;

    @Column(name = "trailer")
    private String trailer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "views")
    private Long views;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private List<Media> mediaList;

}

package net.aht.internship.demo.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tblcategory")
public class Category extends AbstractBase {

    @Column(name = "category_code")
    private String code;

    @NotBlank(message = "Category's name must not blank")
    @Column(name = "category_name")
    private String name;

//	@Lob
//	@NotBlank(message = "Category's description must not blank")
//	private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToStringExclude
    private Collection<Film> films;

}

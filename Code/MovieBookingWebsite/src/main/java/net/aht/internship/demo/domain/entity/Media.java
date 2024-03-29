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
@Table(name = "tblmedia")
public class Media extends AbstractBase{

    private static final long serialVersionUID = 1L;

    @Column(name = "media_mediaUrl")
    private String mediaUrl;

    @Column(name = "media_caption")
    private String caption;

    @Column(name = "media_type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "combo_id")
    private Combo combo;

}

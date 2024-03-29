package net.aht.internship.demo.domain.entity.composite_key;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderComboDetailId implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Long order;

    private Long combo;

}

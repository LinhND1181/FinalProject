package net.aht.internship.demo.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.aht.internship.demo.domain.entity.composite_key.OrderComboDetailId;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(OrderComboDetailId.class)
@Table(name = "tbloc_detail") // ocd is ordercombo_detail
public class OrderComboDetail extends AbstractBase {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "oc_detail_id")
    private Combo combo;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "oc_detail_combo_quantity")
    private Integer comboQuantity;

    @Column(name = "oc_detail_price")
    private Double price;

}

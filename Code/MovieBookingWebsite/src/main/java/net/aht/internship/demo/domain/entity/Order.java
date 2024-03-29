package net.aht.internship.demo.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "tblorder")
public class Order extends AbstractBase {

    private static final long serialVersionUID = 1L;

    @Column(name = "order_payment_method")
    private String paymentMethod;

    @Column(name = "order_status")
    private String status;

    @Column(name = "order_number_of_combos")
    private int numberOfCombos;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}

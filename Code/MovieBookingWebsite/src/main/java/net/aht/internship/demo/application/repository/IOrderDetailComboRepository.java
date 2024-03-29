package net.aht.internship.demo.application.repository;

import net.aht.internship.demo.domain.entity.OrderComboDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDetailComboRepository extends JpaRepository<OrderComboDetail, Long> {

}

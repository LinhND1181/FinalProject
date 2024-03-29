package net.aht.internship.demo.application.repository;

import net.aht.internship.demo.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Long> {

}

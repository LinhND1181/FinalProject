package net.aht.internship.demo.application.repository;

import net.aht.internship.demo.domain.entity.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShowSeatRepository extends JpaRepository<ShowSeat, Long> {

}

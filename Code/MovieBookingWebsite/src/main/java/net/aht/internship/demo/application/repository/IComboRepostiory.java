package net.aht.internship.demo.application.repository;

import net.aht.internship.demo.domain.entity.Combo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IComboRepostiory extends JpaRepository<Combo, Long> {

}

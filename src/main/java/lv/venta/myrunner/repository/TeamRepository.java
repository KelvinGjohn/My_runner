package lv.venta.myrunner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lv.venta.myrunner.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

}
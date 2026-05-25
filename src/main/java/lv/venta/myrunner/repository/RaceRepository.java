package lv.venta.myrunner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lv.venta.myrunner.model.Race;

@Repository
public interface RaceRepository extends JpaRepository<Race, Integer> {

}
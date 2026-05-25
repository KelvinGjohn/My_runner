package lv.venta.myrunner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lv.venta.myrunner.model.Runner;

@Repository
public interface RunnerRepository extends JpaRepository<Runner, Integer> {

}
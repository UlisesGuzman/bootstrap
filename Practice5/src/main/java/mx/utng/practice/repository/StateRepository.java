package mx.utng.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.utng.practice.model.State;

public interface StateRepository extends JpaRepository<State, Long>{

}

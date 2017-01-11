package mx.utng.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.utng.practice.model.Chair;

public interface ChairRepository extends JpaRepository<Chair, Long> {

	@Query("select chair from Chair chair")
	public List<Chair> finAll();
}

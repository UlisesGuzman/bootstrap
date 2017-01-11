package mx.utng.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.utng.practice.model.Pencil;

public interface PencilRepository extends JpaRepository<Pencil, Long> {

	@Query("select pencil from Pencil pencil")
	public List<Pencil> finAll();
}

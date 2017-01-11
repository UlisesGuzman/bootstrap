package mx.utng.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.utng.practice.model.Country;


public interface CountryRepository extends JpaRepository<Country, Long> {
	@Query("select country from Country country")
	public List<Country> finAll();
}

package boot.dao;

import org.springframework.data.repository.CrudRepository;

import boot.model.Shoe;


public interface ShoeRepository extends CrudRepository<Shoe,Integer> {
	
	

}

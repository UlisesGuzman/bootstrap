package boot.dao;

import org.springframework.data.repository.CrudRepository;
import boot.model.Lion;


public interface LionRepository extends CrudRepository<Lion,Integer> {
	 
}

package boot.dao;

import org.springframework.data.repository.CrudRepository;

import boot.model.Property;


public interface PropertyRepository extends CrudRepository <Property, Integer>{

}

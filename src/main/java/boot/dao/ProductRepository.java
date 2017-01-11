package boot.dao;

import org.springframework.data.repository.CrudRepository;


import boot.model.Product;

public interface ProductRepository extends CrudRepository<Product,Integer> {

}

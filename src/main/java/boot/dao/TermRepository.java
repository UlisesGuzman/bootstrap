package boot.dao;

import org.springframework.data.repository.CrudRepository;

import boot.model.Term;

public interface TermRepository extends CrudRepository<Term,Integer> {

}

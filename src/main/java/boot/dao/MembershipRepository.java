package boot.dao;

import org.springframework.data.repository.CrudRepository;

import boot.model.Membership;


public interface MembershipRepository extends CrudRepository<Membership,Integer> {

}

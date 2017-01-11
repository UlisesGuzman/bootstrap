package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.MembershipRepository;
import boot.model.Membership;



@Service @Transactional
public class MembershipService {

	private final MembershipRepository membershipRepository;

	public MembershipService(MembershipRepository membershipRepository){
		super();
		this.membershipRepository= membershipRepository;
	}
	
	public List <Membership> findAll(){
		List<Membership> memberships = new ArrayList<Membership>();
		for(Membership membership : membershipRepository.findAll() ){
			memberships.add(membership);
		}
		return memberships;
	}
	
	public void save(Membership membership){
		membershipRepository.save(membership);
	}
	
	public void delete(int id){
		membershipRepository.delete(id);
	}
	
	public  Membership finOne(int id){
	return membershipRepository.findOne(id);
	}
}

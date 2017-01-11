package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.LionRepository;
import boot.model.Lion;


@Service @Transactional
public class LionService {
	private final LionRepository lionRepository;

	public LionService(LionRepository lionRepository){
		super();
		this.lionRepository= lionRepository;
	}
	
	public List <Lion> findAll(){
		List<Lion> lions = new ArrayList<Lion>();
		for(Lion lion : lionRepository.findAll() ){
			lions.add(lion);
		}
		return lions;
	}
	
	public void save(Lion lion){
		lionRepository.save(lion);
	}
	
	public void delete(int id){
		lionRepository.delete(id);
	}
	
	public  Lion finOne(int id){
	return lionRepository.findOne(id);
	}
}

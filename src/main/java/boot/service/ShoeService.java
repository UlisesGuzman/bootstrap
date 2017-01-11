package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.ShoeRepository;

import boot.model.Shoe;


@Service @Transactional
public class ShoeService {
	
private final ShoeRepository shoeRepository;
	
	public ShoeService(ShoeRepository shoeRepository){
		super();
		this.shoeRepository= shoeRepository;
	}
	
	public List <Shoe> findAll(){
		List<Shoe> shoes = new ArrayList<Shoe>();
		for(Shoe shoe : shoeRepository.findAll() ){
			shoes.add(shoe);
		}
		return shoes;
	}
	
	
	public void save(Shoe shoe){
		shoeRepository.save(shoe);
	}
	
	
	public void delete(int id){
		shoeRepository.delete(id);
	}
	public Shoe finOne(int id){
	return shoeRepository.findOne(id);
	}

}

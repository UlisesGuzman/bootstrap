package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.PencilRepository;
import boot.dao.TaskRepository;
import boot.model.Pencil;
import boot.model.Task;

@Service @Transactional
public class PencilService {

private final PencilRepository pencilRepository;
	
	public PencilService(PencilRepository pencilRepository){
		super();
		this.pencilRepository= pencilRepository;
	}
	
	public List <Pencil> findAll(){
		List<Pencil> pencils = new ArrayList<Pencil>();
		for(Pencil pencil : pencilRepository.findAll() ){
			pencils.add(pencil);
		}
		return pencils;
	}
	
	
	public void save(Pencil pencil){
		pencilRepository.save(pencil);
	}
	
	
	public void delete(int id){
		pencilRepository.delete(id);
	}
	public  Pencil finOne(int id){
	return pencilRepository.findOne(id);
	}
}

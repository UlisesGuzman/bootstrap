package mx.utng.practice.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import mx.utng.practice.model.Chair;
import mx.utng.practice.repository.ChairRepository;

@Named
@ViewScoped
public class ChairController {
	
	@Autowired
	private ChairRepository chairRepository;
	private Chair chair = new Chair();
   private List<Chair> chairs;
   private boolean editMode = false;
   
   @PostConstruct
	public void init(){
	   setChairs(chairRepository.finAll());
	}
	public void save(){
		chairRepository.save(chair);
		if(!editMode){
		 getChairs().add(chair);
		}
		
		chair = new Chair();
		setEditMode(false);
		
		}
	
	public void delete(Chair chair){
		chairRepository.delete(chair);
		chairs.remove(chair);
	}
	
	public void update(Chair chair){
		setChair(chair);
		setEditMode(true);
	}
	public void cancel(){
		chair = new Chair();
		setEditMode(false);
	}
	public ChairRepository getChairRepository() {
		return chairRepository;
	}
	public void setChairRepository(ChairRepository chairRepository) {
		this.chairRepository = chairRepository;
	}
	public Chair getChair() {
		return chair;
	}
	public void setChair(Chair chair) {
		this.chair = chair;
	}
	public List<Chair> getChairs() {
		return chairs;
	}
	public void setChairs(List<Chair> chairs) {
		this.chairs = chairs;
	}
	public boolean isEditMode() {
		return editMode;
	}
	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}
	
	
}




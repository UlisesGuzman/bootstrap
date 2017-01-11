package mx.utng.practice.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import mx.utng.practice.model.Pencil;
import mx.utng.practice.repository.PencilRepository;

@Named
@ViewScoped
public class PencilController {
	
	@Autowired
	private PencilRepository pencilRepository;
	private Pencil pencil = new Pencil();
   private List<Pencil> pencils;
   private boolean editMode = false;
  
   
   @PostConstruct
	public void init(){
	   setPencils(pencilRepository.finAll());
	}
	public void save(){
		pencilRepository.save(pencil);
		if(!editMode){
		 getPencils().add(pencil);
		}
		pencil = new Pencil();
		setEditMode(false);
		
		}
	
	public void delete(Pencil pencil){
		pencilRepository.delete(pencil);
		pencils.remove(pencil);
	}
	
	public void update(Pencil pencil){
		setPencil(pencil);
		setEditMode(true);
	}
	public void cancel(){
		pencil = new Pencil();
		setEditMode(false);
	}


	public PencilRepository getPencilRepository() {
		return pencilRepository;
	}
	public void setPencilRepository(PencilRepository pencilRepository) {
		this.pencilRepository = pencilRepository;
	}
	public Pencil getPencil() {
		return pencil;
	}
	public void setPencil(Pencil pencil) {
		this.pencil = pencil;
	}
	public List<Pencil> getPencils() {
		return pencils;
	}
	public void setPencils(List<Pencil> pencils) {
		this.pencils = pencils;
	}
	public boolean isEditMode() {
		return editMode;
	}


	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	
	
}

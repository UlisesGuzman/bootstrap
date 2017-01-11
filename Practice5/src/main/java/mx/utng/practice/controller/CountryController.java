package mx.utng.practice.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import mx.utng.practice.model.Country;
import mx.utng.practice.repository.CountryRepository;

@Named
@ViewScoped
public class CountryController {
	@Autowired
	private CountryRepository countryRepository;
	private Country country = new Country();
   private List<Country> countries;
   private boolean editMode = false;
   
   @PostConstruct
	public void init(){
	   setCountries(countryRepository.finAll());
	}
   
	public void save(){
		countryRepository.save(country);
		if(!editMode){
		 getCountries().add(country);
		}
		country = new Country();
		setEditMode(false);
		}
	
	public void delete(Country country){
		countryRepository.delete(country);
		countries.remove(country);
	}
	
	public void update(Country country){
		setCountry(country);
		setEditMode(true);
	}
	public void cancel(){
		country = new Country();
		setEditMode(false);
	}
	public CountryRepository getCountryRepository() {
		return countryRepository;
	}
	public void setCountryRepository(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public List<Country> getCountries() {
		return countries;
	}
	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	public boolean isEditMode() {
		return editMode;
	}
	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}	
}

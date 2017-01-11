package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.PropertyRepository;

import boot.model.Property;

@Service @Transactional
public class PropertyService {

	private final PropertyRepository propertyRepository;
	
	public PropertyService(PropertyRepository propertyRepository){
		super();
		this.propertyRepository= propertyRepository;
	}
	
	public List <Property> findAll(){
		List<Property> properties = new ArrayList<Property>();
		for(Property property : propertyRepository.findAll() ){
			properties.add(property);
		}
		return properties;
	}
	
	public void save(Property property){
		propertyRepository.save(property);
	}
	
	public void delete(int id){
		propertyRepository.delete(id);
	}
	
	public  Property finOne(int id){
	return propertyRepository.findOne(id);
	}
}

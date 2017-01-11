package boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Lion;
import boot.model.Property;
import boot.service.LionService;
import boot.service.PropertyService;

@Controller
public class PropertyController {
	@Autowired
	private PropertyService propertyService;
	
	@GetMapping("/properties")
	public String home(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "properties";
	}
	
	@GetMapping("/all-properties")
	public String allPropesties(HttpServletRequest request) {
		request.setAttribute("properties", propertyService.findAll());
		request.setAttribute("mode", "MODE_PROPERTIES");
		return "properties";
	}
	
	@GetMapping("/new-property")
	public String newProperty(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_NEW");
		return "properties";
	}

	
	@PostMapping("/save-property")
	public String saveProperty(@ModelAttribute Property property, 
			BindingResult bindingResult, HttpServletRequest request) {
		propertyService.save(property);
		request.setAttribute("properties", propertyService.findAll());
		request.setAttribute("mode", "MODE_PROPERTIES");		
		return "properties";
	}
	
	@GetMapping("/update-property")
	public String updateProperty(@RequestParam int id, HttpServletRequest request) {
	request.setAttribute("property", propertyService.finOne(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "properties";
	}	
	
	
	@GetMapping("/delete-property")
	public String deleteProperty(@RequestParam int id, HttpServletRequest request) {
    propertyService.delete(id);
	request.setAttribute("properties",propertyService.findAll());
		request.setAttribute("mode", "MODE_PROPERTIES");
		return "properties";
	}
}

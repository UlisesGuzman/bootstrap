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
import boot.service.LionService;



@Controller
public class LionController {

	@Autowired
	private LionService lionService;
	
	@GetMapping("/lions")
	public String home(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "lions";
	}
	
	@GetMapping("/all-lions")
	public String allLions(HttpServletRequest request) {
		request.setAttribute("lions", lionService.findAll());
		request.setAttribute("mode", "MODE_LIONS");
		return "lions";
	}
	
	@GetMapping("/new-lion")
	public String newLion(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_NEW");
		return "lions";
	}

	
	@PostMapping("/save-lion")
	public String saveLion(@ModelAttribute Lion lion, 
			BindingResult bindingResult, HttpServletRequest request) {
		lionService.save(lion);
		request.setAttribute("lions", lionService.findAll());
		request.setAttribute("mode", "MODE_LIONS");		
		return "lions";
	}
	
	@GetMapping("/update-lion")
	public String updateLion(@RequestParam int id, HttpServletRequest request) {
	request.setAttribute("lion", lionService.finOne(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "lions";
	}	
	
	
	@GetMapping("/delete-lion")
	public String deleteLion(@RequestParam int id, HttpServletRequest request) {
    lionService.delete(id);
	request.setAttribute("lions",lionService.findAll());
		request.setAttribute("mode", "MODE_LIONS");
		return "lions";
	}
}

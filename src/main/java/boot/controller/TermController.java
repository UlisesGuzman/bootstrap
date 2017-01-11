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
import boot.model.Term;
import boot.service.LionService;
import boot.service.TermService;

@Controller
public class TermController {

	@Autowired
	private TermService termService;
	
	@GetMapping("/terms")
	public String home(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "terms";
	}
	
	@GetMapping("/all-terms")
	public String allTerms(HttpServletRequest request) {
		request.setAttribute("terms", termService.findAll());
		request.setAttribute("mode", "MODE_TERMS");
		return "terms";
	}
	
	@GetMapping("/new-term")
	public String newTerm(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_NEW");
		return "terms";
	}

	
	@PostMapping("/save-term")
	public String saveTerm(@ModelAttribute Term term, 
			BindingResult bindingResult, HttpServletRequest request) {
		termService.save(term);
		request.setAttribute("terms", termService.findAll());
		request.setAttribute("mode", "MODE_TERMS");		
		return "terms";
	}
	
	@GetMapping("/update-term")
	public String updateTerm(@RequestParam int id, HttpServletRequest request) {
	request.setAttribute("term", termService.finOne(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "terms";
	}	
	
	
	@GetMapping("/delete-term")
	public String deleteTerm(@RequestParam int id, HttpServletRequest request) {
		termService.delete(id);
	request.setAttribute("terms",termService.findAll());
		request.setAttribute("mode", "MODE_TERMS");
		return "terms";
	}
}

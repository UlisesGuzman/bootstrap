package boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Pencil;

import boot.service.PencilService;


@Controller
public class PencilController {
	@Autowired
	private PencilService pencilService;

	@GetMapping("/pencils")
	public String home(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "pencils";
	}

	@GetMapping("/all-pencils")
	public String allPencils(HttpServletRequest request) {
		request.setAttribute("pencils", pencilService.findAll());
		request.setAttribute("mode", "MODE_PENCILS");
		return "pencils";
	}

	@GetMapping("/new-pencil")
	public String newPencil(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_NEW");
		return "pencils";
	}

	
	@PostMapping("/save-pencil")
	public String savePencil(@ModelAttribute Pencil pencil, 
			BindingResult bindingResult, HttpServletRequest request) {
		pencilService.save(pencil);
		request.setAttribute("pencils", pencilService.findAll());
		request.setAttribute("mode", "MODE_PENCIL");		
		return "pencils";
	}
	
	@GetMapping("/update-pencil")
	public String updatePencil(@RequestParam int id, HttpServletRequest request) {
	request.setAttribute("pencil",pencilService.finOne(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "pencils";
	}	
	
	
	@GetMapping("/delete-pencil")
	public String deletePencil(@RequestParam int id, HttpServletRequest request) {
   pencilService.delete(id);
	request.setAttribute("pencils", pencilService.findAll());
		request.setAttribute("mode", "MODE_PENCILS");
		return "pencils";
	}	
}

package boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Shoe;
import boot.service.ShoeService;

@Controller
public class ShoeController {
	
	@Autowired
	private ShoeService shoeService;

	@GetMapping("/shoes")
	public String home(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "shoes";
	}

	@GetMapping("/all-shoes")
	public String allShoes(HttpServletRequest request) {
		request.setAttribute("shoes", shoeService.findAll());
		request.setAttribute("mode", "MODE_SHOES");
		return "shoes";
	}

	@GetMapping("/new-shoe")
	public String newShoe(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_NEW");
		return "shoes";
	}

	
	@PostMapping("/save-shoe")
	public String saveShoe(@ModelAttribute Shoe shoe, 
			BindingResult bindingResult, HttpServletRequest request) {
		shoeService.save(shoe);
		request.setAttribute("shoes", shoeService.findAll());
		request.setAttribute("mode", "MODE_SHOES");		
		return "shoes";
	}
	
	@GetMapping("/update-shoe")
	public String updateShoe(@RequestParam int id, HttpServletRequest request) {
	request.setAttribute("shoe", shoeService.finOne(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "shoes";
	}	
	
	
	@GetMapping("/delete-shoe")
	public String deleteShoe(@RequestParam int id, HttpServletRequest request) {
    shoeService.delete(id);
	request.setAttribute("shoes", shoeService.findAll());
		request.setAttribute("mode", "MODE_SHOES");
		return "shoes";
	}	


}

package boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Membership;
import boot.service.MembershipService;



@Controller
public class MembershipController {
	
	@Autowired
	private MembershipService membershipService;
	
	@GetMapping("/memberships")
	public String home(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "memberships";
	}
	
	@GetMapping("/all-memberships")
	public String allMemberships(HttpServletRequest request) {
		request.setAttribute("memberships", membershipService.findAll());
		request.setAttribute("mode", "MODE_MEMBERSHIPS");
		return "memberships";
	}
	
	@GetMapping("/new-membership")
	public String newMembership(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_NEW");
		return "memberships";
	}

	
	@PostMapping("/save-membership")
	public String saveMembership(@ModelAttribute Membership membership, 
			BindingResult bindingResult, HttpServletRequest request) {
		membershipService.save(membership);
		request.setAttribute("memberships", membershipService.findAll());
		request.setAttribute("mode", "MODE_MEMBERSHIPS");		
		return "memberships";
	}
	
	@GetMapping("/update-membership")
	public String updateMembership(@RequestParam int id, HttpServletRequest request) {
	request.setAttribute("membership", membershipService.finOne(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "memberships";
	}	
	
	
	@GetMapping("/delete-membership")
	public String deleteMembership(@RequestParam int id, HttpServletRequest request) {
		membershipService.delete(id);
	request.setAttribute("memberships",membershipService.findAll());
		request.setAttribute("mode", "MODE_MEMBERSHIPS");
		return "memberships";
	}
}

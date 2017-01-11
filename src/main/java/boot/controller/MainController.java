package boot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;

//import org.apache.hadoop.mapred.taskdetails_jsp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Task;
import boot.service.TaskService;

@Controller
public class MainController {

	@GetMapping("/")
	public String home(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}
}

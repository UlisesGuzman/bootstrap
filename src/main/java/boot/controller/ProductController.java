package boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Product;
import boot.service.ProductService;




@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public String home(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "products";
	}

	@GetMapping("/all-products")
	public String allProducts(HttpServletRequest request) {
		request.setAttribute("products", productService.findAll());
		request.setAttribute("mode", "MODE_PRODUCTS");
		return "products";
	}

	@GetMapping("/new-product")
	public String newProduct(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_NEW");
		return "products";
	}

	
	@PostMapping("/save-product")
	public String saveProduct(@ModelAttribute Product product, 
			BindingResult bindingResult, HttpServletRequest request) {
		productService.save(product);
		request.setAttribute("products", productService.findAll());
		request.setAttribute("mode", "MODE_PRODUCTS");		
		return "products";
	}
	
	@GetMapping("/update-product")
	public String updateProduct(@RequestParam int id, HttpServletRequest request) {
	request.setAttribute("product", productService.finOne(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "products";
	}	
	
	
	@GetMapping("/delete-product")
	public String deleteProduct(@RequestParam int id, HttpServletRequest request) {
		productService.delete(id);
	request.setAttribute("products", productService.findAll());
		request.setAttribute("mode", "MODE_PRODUCTS");
		return "products";
	}	

}

package example.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import example.spring.mvc.models.User;
import example.spring.mvc.models.UserValidator;
import jakarta.servlet.http.HttpServletRequest;

@Controller //Marks this class as a controller implementation class
@SessionAttributes({"loggedInUser"})
public class SpringMvcController {
	//@RequestMapping("/doGreet")//GET
	@GetMapping("/doGreet")
	public String getGreetingPage() {
		System.out.println("Request Received");
		String viewName = "greet";
		return viewName;
	}
	
	//@RequestMapping("/doLogin")//GET
	@GetMapping("/doLogin")
	public String getLoginPage() {
		String viewName = "login"; 
		return viewName;		
	}
	
	//@RequestMapping(value = "/doValidate", method = RequestMethod.POST)//POST
	/*
	@PostMapping("/doValidate")
	public String getResultPage(HttpServletRequest request) {
		String result = "failure";
		String userId = request.getParameter("uid");
		String password = request.getParameter("pwd");
		User userObj = new User(userId, password);
		boolean valid = UserValidator.isValid(userObj);
		if(valid)
			result = "success";
		return result;
	}
	*/
	@PostMapping("/doValidate")
	public String getResultPage(
			@RequestParam("uid") String userId, 
			@RequestParam("pwd") String password,
			Model modelObject
			) {
		String result = "failure";
		User userObj = new User(userId, password);
		boolean valid = UserValidator.isValid(userObj);
		if(valid) { //Store username into model
			modelObject.addAttribute("loggedInUser", userId);
			result = "success";
		}
		return result;
	}
}














package hh3.sof.WatchlistApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hh3.sof.WatchlistApp.domain.SignUpForm;
import hh3.sof.WatchlistApp.domain.User;
import hh3.sof.WatchlistApp.domain.UserRepository;
import jakarta.validation.Valid;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/login")
	public String login() {
		return "login";
		
	}
	
	@GetMapping("/signup")
	public String addUser(Model model) {
		model.addAttribute("signupform", new SignUpForm());
		return "signup";
	}
	
	
	@PostMapping("/saveuser")
	    public String save(@Valid @ModelAttribute("signupform") SignUpForm signupForm, BindingResult bindingResult) {
	    	if (!bindingResult.hasErrors()) { // validation errors
	    		if (signupForm.getPassword().equals(signupForm.getPasswordCheck())) { // check password match		
		    		String pwd = signupForm.getPassword();
			    	BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
			    	String hashPwd = bc.encode(pwd);
		
			    	User newUser = new User();
			    	newUser.setPasswordHash(hashPwd);
			    	newUser.setUsername(signupForm.getUsername());
			    	newUser.setRole("USER");
			    	if (userRepository.findByUsername(signupForm.getUsername()) == null) { // Check if user exists
			    		userRepository.save(newUser);
			    	}
			    	else {
		    			bindingResult.rejectValue("username", "err.username", "Username already exists");    	
		    			return "signup";		    		
			    	}
	    		}
	    		else {
	    			bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords does not match");    	
	    			return "signup";
	    		}
	    	}
	    	else {
	    		return "signup";
	    	}
	    	return "redirect:/login";    	
	    }    
	    
	}




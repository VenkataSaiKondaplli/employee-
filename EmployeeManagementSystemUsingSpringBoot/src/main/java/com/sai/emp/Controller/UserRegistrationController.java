package com.sai.emp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sai.emp.Service.Userservice;
import com.sai.emp.UserRegistrationDto.UserRegistrationDto;


@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	
	
	
		private Userservice userService;

		public UserRegistrationController(Userservice userService) {
			super();
			this.userService = userService;
		}
		
		@ModelAttribute("user")
	    public UserRegistrationDto userRegistrationDto() {
	        return new UserRegistrationDto();
	    }
		
		@GetMapping
		public String showRegistrationForm() {
			return "registration";
		}
		
		@PostMapping
		public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
			userService.save(registrationDto);
			return "redirect:/registration?success";
			
		}
		

}

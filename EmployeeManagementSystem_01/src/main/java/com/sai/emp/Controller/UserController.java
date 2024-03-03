package com.sai.emp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sai.emp.Model.UserData;
import com.sai.emp.Repository.UserRepository;

import jakarta.servlet.http.HttpSession;

/*
 * @Controller public class UserController {
 * 
 * @Autowired private UserRepository userRepository;
 * 
 * @PostMapping("/register") public String registerUser(@ModelAttribute UserData
 * user) { userRepository.save(user); return "redirect:/login"; }
 * 
 * @GetMapping("/login") public String loginUser(@RequestParam String
 * username, @RequestParam String password, HttpSession session) {
 * 
 * UserData user = userRepository.findByUsername(username); if (user != null &&
 * user.getPassword().equals(password)) { session.setAttribute("loggedInUser",
 * user); return "redirect:/employees"; } else { return "redirect:/login?error";
 * } }
 * 
 * 
 * }
 */
@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserData user) {
        userRepository.save(user);
        return "redirect:/login";
    }

    @RequestMapping(value = "/login.jsp", method = {RequestMethod.GET, RequestMethod.POST})
    public String loginUser(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, HttpSession session) {
        UserData user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("loggedInUser", user);
            return "redirect:/employees";
        } else {
            return "redirect:/login?error";
        }
    }
}

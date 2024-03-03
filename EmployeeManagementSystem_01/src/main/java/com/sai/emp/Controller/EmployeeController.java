package com.sai.emp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sai.emp.Model.EmployeeData;
import com.sai.emp.Model.UserData;
import com.sai.emp.Repository.EmployeeRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public String getAllEmployees(Model model, HttpSession session) {
        // Check if the user is logged in, otherwise redirect to the login page
        UserData loggedInUser = (UserData) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:/login";
        }

        List<EmployeeData> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "employees";
    }

    @PostMapping("/employees/add")
    public String addEmployee(@ModelAttribute EmployeeData employee) {
        
        employeeRepository.save(employee);
        return "redirect:/employees";
    }

    @PutMapping("/employees/update/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute EmployeeData employee) {
        UserData loggedInUser = (UserData) ((Model) employee).getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:/login";
        }
        
        // Update the employee with the given ID in the database
        EmployeeData existingEmployee = employeeRepository.findById(id).orElse(null);
        if (existingEmployee != null) {
            existingEmployee.setUsername(employee.getUsername());
            existingEmployee.setDesignation(employee.getDesignation());
            //existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setMobileno(employee.getMobileno());
            existingEmployee.setAddress(employee.getAddress());
            
            // Set other properties of the employee as needed
            employeeRepository.save(existingEmployee);
        }

        return "redirect:/employees";
    }

    
    
    
    @PostMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        // Delete the employee with the given ID from the database
        employeeRepository.deleteById(id);
        return "redirect:/employees";
    }

}

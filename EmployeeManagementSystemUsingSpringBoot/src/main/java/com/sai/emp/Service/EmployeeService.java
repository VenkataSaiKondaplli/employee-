package com.sai.emp.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.sai.emp.Model.EmployeeMS;



public interface EmployeeService {
	
	List<EmployeeMS> getAllEmployees();
	void saveEmployee(EmployeeMS employee);
	EmployeeMS getEmployeeById(long id);
	void deleteEmployeeById(long id);
	Page<EmployeeMS> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}

package com.sai.emp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sai.emp.Model.EmployeeData;

public interface EmployeeRepository extends JpaRepository<EmployeeData, Long>  {
	
	

}

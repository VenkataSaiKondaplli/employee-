package com.sai.emp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sai.emp.Model.EmployeeMS;
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeMS, Long> {

}

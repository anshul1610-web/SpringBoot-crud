package com.in28Min.Service;

import java.util.List;

import com.in28Min.Entity.Employee;

public interface EmployeeService {

	 public Employee addEmployee(Employee employee);

	 public List<Employee> getAllEmployee();

	 public Employee getEmployee(Long id);

	 public void deleteById(Long id);

	
	
}

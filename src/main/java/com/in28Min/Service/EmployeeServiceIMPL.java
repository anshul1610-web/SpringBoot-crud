package com.in28Min.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28Min.CustomException.ServiceClassException;
import com.in28Min.Entity.Employee;
import com.in28Min.Repository.EmployeeRepository;

@Service
public class EmployeeServiceIMPL implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public Employee addEmployee(Employee employee) {
		if(employee.getName().isEmpty()||employee.getName().length()==0) {
			throw new ServiceClassException("601","employee name is null");
		}
		try {
			Employee savedEmployee = repository.save(employee);
			return savedEmployee;	
		}catch(IllegalArgumentException e) {
			throw new ServiceClassException("602","employee object is null "+e.getMessage());
		}catch(Exception e){
			throw new ServiceClassException("602","something went wrong while saving employee "+e.getMessage());
			}
		}	

	@Override
	public List<Employee> getAllEmployee() {
		 List<Employee> allEmpList = null;	 
		 try {
			 allEmpList = repository.findAll();
			}catch(Exception e) {
				throw new ServiceClassException("602","something went wrong while fetching all employees "+e.getMessage());
			}
		    if(allEmpList.isEmpty()) {
			 throw new ServiceClassException("604","employee list is empty");
		 } return allEmpList;
	} 
		

	
	@Override
	public Employee getEmployee(Long id) {
		try {
			return repository.findById(id).get();
		}catch(IllegalArgumentException e) {
			throw new ServiceClassException("605","given employe id is null "+e.getMessage());
		}catch(NoSuchElementException e) {
			throw new ServiceClassException("605","given employee id does not exist "+e.getMessage());
		}
		
	}

	@Override
	public void deleteById(Long id) {
//		try {
//			repository.deleteById(id);
//		}catch(IllegalArgumentException e) {
//			throw new ServiceClassException("605","given employe id is null "+e.getMessage());
//		}catch(NoSuchElementException e) {
//			throw new ServiceClassException("605","given employe id does not exist "+e.getMessage());
//		}
		repository.deleteById(id);
	}
}

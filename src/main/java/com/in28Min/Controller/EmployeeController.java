package com.in28Min.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28Min.CustomException.ControllerException;
import com.in28Min.CustomException.ServiceClassException;
import com.in28Min.Entity.Employee;
import com.in28Min.Service.EmployeeService;


@RestController
@RequestMapping("/emp")
public class EmployeeController {
   
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/save")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee ){
		try {
			  Employee addedEmployee = service.addEmployee(employee);
		      return new ResponseEntity<Employee>(addedEmployee,HttpStatus.CREATED);	
	   }catch(ServiceClassException e) {
		   ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
		   return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);	
	   }catch(Exception e) {
		   ControllerException ce = new ControllerException("606","something went wrong in controller "+e.getMessage());
		   return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
	   }
	}
		
		
	
	@GetMapping("employees")
	public ResponseEntity<?> getListEmployee(){
		try {
			List<Employee> allEmployee = service.getAllEmployee();
			return new ResponseEntity<List<Employee>>(allEmployee,HttpStatus.OK);
		}catch(ServiceClassException e) {
			   ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
			   return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);	
	    }catch(Exception e) {
			   ControllerException ce = new ControllerException("606","something went wrong in controller "+e.getMessage());
			   return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		   }
	}
	
	@GetMapping("employee/{id}")
	public ResponseEntity<?> getListEmployee(@PathVariable Long id){
		try {
			Employee employeeRetrived = service.getEmployee(id);
			return new ResponseEntity<Employee>(employeeRetrived,HttpStatus.OK);
		}catch(ServiceClassException e) {
			   ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
			   return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);	
	    }catch(Exception e) {
			   ControllerException ce = new ControllerException("606","something went wrong in controller "+e.getMessage());
			   return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		   }
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
//		try {
//			service.deleteById(id);
//			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
//		}catch(ServiceClassException e) {
//			   ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
//			   return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);	
//		}catch(Exception e) {
//			   ControllerException ce = new ControllerException("606","something went wrong in controller "+e.getMessage());
//			   return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
//		   }
		service.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
		
	
	@PutMapping("/update")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee ){
		try {
			Employee addedEmployee = service.addEmployee(employee);
			return new ResponseEntity<Employee>(addedEmployee,HttpStatus.CREATED);	
		}catch(ServiceClassException e) {
			   ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
			   return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);	
	    }catch(Exception e) {
			   ControllerException ce = new ControllerException("606","something went wrong in controller "+e.getMessage());
			   return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		   }
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "<h1>Welcome Admin</h1>";
	}
	
	@GetMapping("/user")
	public String user() {
		return "<h1>Welcome User</h1>";
	}
	
}

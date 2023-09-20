package com.in28Min.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.in28Min.Entity.Employee;
import com.in28Min.Repository.EmployeeRepository;

@SpringBootTest
public class EmployeeServiceIMPLTest {
	
	@InjectMocks
	EmployeeServiceIMPL serviceImpl;
	
	@Mock
	EmployeeRepository repository;
	
	@Test
	public void getEmployee() {
		when(repository.findById(1L)).thenReturn(createEmployeeStub());
		Employee testEmp = serviceImpl.getEmployee(1L);
		assertEquals(testEmp.getName(), "Decode");
	}
	
	private Optional<Employee> createEmployeeStub(){
		Employee empStub =new Employee(1L,"Decode", 0);
		return Optional.of(empStub);
		
	}

}

package com.in28Min.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28Min.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

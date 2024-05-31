package net.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	 @Query("SELECT e FROM Employee e WHERE e.id NOT IN (SELECT DISTINCT b.employee.id FROM Branch b)")
	    List<Employee> findEmployeesWithoutBranches();
}



package net.springboot;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import net.springboot.model.Employee;
import net.springboot.repository.BranchRepository;
import net.springboot.repository.EmployeeRepository;
import net.springboot.service.BranchService;

@SpringBootApplication
@ComponentScan(basePackages = "net.springboot")
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private BranchRepository branchRepository;
	
	@Autowired
	private BranchService branchService;
	

	@Override
	public void run(String... args) throws Exception {
		
		 List<Employee> employees = employeeRepository.findAll();

		    // Print the names of all employees
		    System.out.println("All Employee Names:");
		    for (Employee employee : employees) {
		        System.out.println(employee.getFirstName());
		    }
//		
//		 Employee emp = new Employee();
//		 emp.setId(1);
//
//         Branch branch = new Branch();
//         branch.setBranchName("Science");
//         branch.addEmpId(emp);
//         Branch newPatient = branchService.saveBranch(branch);
		}
}
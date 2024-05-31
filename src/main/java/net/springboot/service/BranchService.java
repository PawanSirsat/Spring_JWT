package net.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.springboot.model.Branch;
import net.springboot.model.CreateBranchRequest;
import net.springboot.model.Employee;
import net.springboot.repository.BranchRepository;
import net.springboot.repository.EmployeeRepository;

import java.util.List;

@Service
public class BranchService {
    @Autowired
    private BranchRepository branchRepository;

    public List<Branch> getAllBranches() {
        return branchRepository.findAll();
    }
    
    @Autowired
    BranchRepository brachRepo;
    @Autowired
    EmployeeRepository employeeRepository;


    @Transactional
    public Branch createBranch(CreateBranchRequest createBranchRequest) {
        // Fetch the associated employee
        Employee employee = employeeRepository.findById(createBranchRequest.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        // Create a new branch
        Branch branch = new Branch();
        branch.setBranchName(createBranchRequest.getBranchName());
        branch.setEmployee(employee);

        // Save the branch
        return branchRepository.save(branch);
    }
}

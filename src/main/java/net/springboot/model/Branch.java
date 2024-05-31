package net.springboot.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@JsonIgnoreType
@Table(name = "branch")
public class Branch implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne // Many branches can belong to one employee
    @JoinColumn(name = "emp_id") // Name of the foreign key column in the branch table
    private Employee employee; // Reference to the associated employee

    @Column(name = "branch_name")
    private String branchName;
    
    public void addEmpId(Employee emp) {
        emp.branches.add(this);
        this.employee = emp;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Branch() {
		// TODO Auto-generated constructor stub
	}
    
    

}

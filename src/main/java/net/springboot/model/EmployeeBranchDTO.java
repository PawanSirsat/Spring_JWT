package net.springboot.model;

public class EmployeeBranchDTO {
    private String firstName;
    private String branchName;

    public EmployeeBranchDTO(String firstName, String branchName) {
        this.firstName = firstName;
        this.branchName = branchName;
    }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

    
}

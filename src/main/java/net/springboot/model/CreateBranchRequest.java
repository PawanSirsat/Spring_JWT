package net.springboot.model;

public class CreateBranchRequest {

	    private String branchName;
	    private Long employeeId;
	    
		public String getBranchName() {
			return branchName;
		}
		public void setBranchName(String branchName) {
			this.branchName = branchName;
		}
		public Long getEmployeeId() {
			return employeeId;
		}
		public void setEmployeeId(Long employeeId) {
			this.employeeId = employeeId;
		}
	    
	    
}

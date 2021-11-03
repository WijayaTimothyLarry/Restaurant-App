package entityclass;


public class Staff extends Person {

	private String employeeID;
	private String jobTitle;

	public Staff(String name, String gender,String employeeID, String jobTitle) {
		// TODO - implement Staff.Staff
		super(name, gender);
		this.employeeID = employeeID;
		this.jobTitle = jobTitle;
		throw new UnsupportedOperationException();
	}

	public String getEmployeeID() {
		return this.employeeID;
	}

	/**
	 * 
	 * @param employeeID
	 */
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	/**
	 * 
	 * @param jobTitle
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

}
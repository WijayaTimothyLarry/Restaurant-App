package EntityClass;

import java.io.Serializable;

public class Staff extends Person implements Serializable {

	private String employeeID;
	private String jobTitle;

	public Staff() {
		// TODO - implement Staff.Staff
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
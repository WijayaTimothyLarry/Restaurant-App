package entityclass;

public class Staff extends Person {

	/**
	 * Employee ID for a given Staff
	 */
	private String employeeID;

	/**
	 * Job title of a given Staff
	 */
	private String jobTitle;
	
	/**
	 * public : Staff
	 * Constructor to initialise a given Staff
	 * @param name (String) Name of a given Staff
	 * @param gender (String) Gender of a given Staff
	 * @param employeeID (String) Employee ID for a given Staff
	 * @param jobTitle (String) Job Titlte for a given Staff.
	 * @see Person
	 */
	public Staff(String name, String gender, String employeeID, String jobTitle) {

		super(name, gender);
		this.employeeID = employeeID;
		this.jobTitle = jobTitle;
	}

	/**
	 * public String : getEmployeeID
	 * Function to return a given Employee's ID
	 * @return employeeID (String) 
	 */
	public String getEmployeeID() {
		return this.employeeID;
	}

	/**
	 * public void : setEmployeeID
	 * Function to set the Employee ID of a given Employee
	 * @param employeeID (String)
	 */
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	/**
	 * publiv String : getJobTitle
	 * Function to return the jobTitle of a given Staff
	 * @return String 
	 */
	public String getJobTitle() {
		return this.jobTitle;
	}

	/**
	 * public void : setJobTitle
	 * Function to set the Job Title for a given Employee
	 * @param jobTitle 
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

}
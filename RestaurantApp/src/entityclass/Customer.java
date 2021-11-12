package entityclass;

public class Customer extends Person {

	private boolean hasMembership;
	private String phoneNumber;
	/**
	 * Constructor for Customer
	 * Child class of Person
	 * @param name (String)Name of Customer
	 * @param gender (String)Gender of Customer
	 * @param phoneNumber (String)Phone Number of Customer
	 * @param hasMembership (boolean)Whether a customer is a member
	 */

	public Customer(String name, String gender, String phoneNumber, boolean hasMembership) {
		super(name, gender);
		this.hasMembership = hasMembership;
		this.phoneNumber = phoneNumber;

	}

	/**
	 * Function to check if a customer is a member
	 * @return (boolean)true if customer is a member;false otherwise
	 */
	public boolean getHasMembership() {
		return this.hasMembership;
	}

	/**
	 * function to set  membership status of a customer
	 * @param hasMembership
	 */
	public void setHasMembership(boolean hasMembership) {
		this.hasMembership = hasMembership;
	}

	/**
	 * Function to get the phone number of a customer
	 * @return (String)phone number of the customer
	 */
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	/**
	 * function to set the phone number of a customer
	 * @param phoneNumber (String)phone number of the customer
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
package entityclass;

public class Customer extends Person {

	private boolean hasMembership;
	private String phoneNumber;

	public Customer(String name, String gender, String phoneNumber, boolean hasMembership) {
		super(name, gender);
		this.hasMembership = hasMembership;
		this.phoneNumber = phoneNumber;

	}

	public boolean getHasMembership() {
		return this.hasMembership;
	}

	/**
	 * 
	 * @param hasMembership
	 */
	public void setHasMembership(boolean hasMembership) {
		this.hasMembership = hasMembership;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	/**
	 * 
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
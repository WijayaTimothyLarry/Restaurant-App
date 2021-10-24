package entityclass;

import java.io.Serializable;

public class Customer extends Person implements Serializable {

	private boolean hasMembership;

	public Customer(String name, String gender, boolean hasMembership) {
		// TODO - implement Customer.Customer
		super(name, gender);
		this.hasMembership = hasMembership;
		throw new UnsupportedOperationException();
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

}
package entityclass;

public class Customer extends Person {

	private boolean hasMembership;

	public Customer() {
		// TODO - implement Customer.Customer
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
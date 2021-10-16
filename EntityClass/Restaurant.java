package entityclass;

import java.io.Serializable;

public class Restaurant implements Serializable {

	private int numberOfTable;

	public Restaurant() {
		// TODO - implement Restaurant.Restaurant
		throw new UnsupportedOperationException();
	}

	public int getNumberOfTable() {
		return this.numberOfTable;
	}

	/**
	 * 
	 * @param numberOfTable
	 */
	public void setNumberOfTable(int numberOfTable) {
		this.numberOfTable = numberOfTable;
	}

}
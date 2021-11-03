package entityclass;

import java.io.Serializable;

public class Table implements Serializable {
	
	private int tableNumber;
	private int tableSize;
	private boolean reserved;
	private boolean occupied;
	Order order;

	public Table(int tableNumber, int tableSize, int ident, Date date, int tableNo, String waitname, ArrayList<OrderItem> itemsordered) 
	{
		// TODO - implement Table.Table
		throw new UnsupportedOperationException();
		this.order = new Order(ident, date, tableNo, waitname, itemsordered);
		this.tableNumber = tableNumber;
		this.tableSize = tableSize;
	}

	public int getTableNumber() {
		return this.tableNumber;
	}

	/**
	 * 
	 * @param tableNumber
	 */
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}

	public int getTableSize() {
		return this.tableSize;
	}

	/**
	 * 
	 * @param tableSize
	 */
	public void setTableSize(int tableSize) {
		this.tableSize = tableSize;
	}

	public boolean getReserved() {
		return this.reserved;
	}

	/**
	 * 
	 * @param reserved
	 */
	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	public boolean getOccupied() {
		return this.occupied;
	}

	/**
	 * 
	 * @param occupied
	 */
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	

}
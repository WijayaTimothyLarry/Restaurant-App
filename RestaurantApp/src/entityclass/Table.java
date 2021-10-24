package entityclass;

import java.io.Serializable;

public class Table implements Serializable {
	
	private int tableNumber;
	private int tableSize;
	private boolean reserved;
	private boolean occupied;
	Order o;

	public Table() {
		// TODO - implement Table.Table
		throw new UnsupportedOperationException();
		this.o = new Order();
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
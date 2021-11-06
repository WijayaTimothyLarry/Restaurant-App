package entityclass;

import java.io.Serializable;
import java.util.ArrayList;

public class Table implements Serializable {

	private int tableNumber;
	private int tableSize;

	public enum TableStatus {
		EMPTY, OCCUPIED, RESERVED
	}; // Table status' flag varialble

	TableStatus status;
	private ArrayList<Reservation> tableReservation;

	public Table(int tableNumber, int tableSize) // To create a new Table
	{
		this.tableNumber = tableNumber;
		this.tableSize = tableSize;
		this.status = TableStatus.EMPTY;
		this.tableReservation = new ArrayList<Reservation>();
	}

	public int getTableNumber() // Return given Table's number
	{
		return this.tableNumber;
	}

	/**
	 * 
	 * @param tableNumber
	 */

	public int getTableSize() // Return given Table's size
	{
		return this.tableSize;
	}

	/**
	 * 
	 * @param tableSize
	 */
	public void setTableSize(int tableSize) // To set the size of a new Table
	{
		this.tableSize = tableSize;
	}

	public TableStatus getTableStatus() {
		return status;
	}

	public void setToEmpty() // To set the Table's status as Empty
	{
		this.status = TableStatus.EMPTY;
	}

	public void setToOccupied() // To set the Table's status as Occupied
	{
		this.status = TableStatus.OCCUPIED;
	}

	public void setToReserved() // To set the Table's status as Reserved
	{
		this.status = TableStatus.RESERVED;
	}

	public void addReservation(Reservation newReservation) {
		tableReservation.add(newReservation);
	}
}
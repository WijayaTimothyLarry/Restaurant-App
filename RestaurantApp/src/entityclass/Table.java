package entityclass;

import java.io.Serializable;

public class Table implements Serializable 
{

	static int maxTableNumber = 10;
	private int tableNumber;
	private int tableSize;
	public enum TableStatus {EMPTY, OCCUPIED, RESERVED};					// Table status' flag varialble
	private TableStatus status = TableStatus.EMPTY;	
	private int lastTableNumber;	

	public Table(int tableNumber, int tableSize, TableStatus status)		// To create a new Table
	{
		this.tableNumber = lastTableNumber;
		lastTableNumber ++;
		this.tableSize = tableSize;
		this.status = status;
	}

	public int getTableNumber()												// Return given Table's number
	{
		return this.tableNumber;
	}

	/**
	 * 
	 * @param tableNumber
	 */
	

	public int getTableSize()												// Return given Table's size
	{
		return this.tableSize;
	}

	/**
	 * 
	 * @param tableSize
	 */
	public void setTableSize(int tableSize)									// To set the size of a new Table
	{
		this.tableSize = tableSize;
	}

	public void setToEmpty()												// To set the Table's status as Empty
	{
		this.status = TableStatus.EMPTY;
	}

	public void setToOccupied()												// To set the Table's status as Occupied
	{
		this.status = TableStatus.OCCUPIED;
	}
	
	public void setToReserved()												// To set the Table's status as Reserved
	{
		this.status = TableStatus.RESERVED;
	}

}
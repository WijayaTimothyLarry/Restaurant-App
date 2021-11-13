package entityclass;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import database.Restaurant;

public class Table implements Serializable {

	/**
	 * Number of the given Table
	 */
	private int tableNumber;

	/**
	 * Size of the given Table
	 */
	private int tableSize;

	/**
	 * Order of a given Table.
	 */
	private Order tableOrder;

	/**
	 * Enum Status of a given Table
	 */
	public static enum TableStatus {
		EMPTY, OCCUPIED
	};

	private TableStatus status;

	/**
	 * ArrayList of Reservations for a given Table
	 */
	private ArrayList<Reservation> tableReservation;

	/**
	 * public : Table Constructor for a new Table with given tableNumber and
	 * tableSize
	 * 
	 * @param tableNumber (int)
	 * @param tableSize   (int)
	 * @return Table created based on the given tableNumber and tableSize
	 */
	public Table(int tableNumber, int tableSize) // To create a new Table
	{
		this.tableNumber = tableNumber;
		this.tableSize = tableSize;
		this.status = TableStatus.EMPTY;
		this.tableOrder = null;
		this.tableReservation = new ArrayList<Reservation>();
	}

	/**
	 * public int : getTableNumber Function that returns the given tableNumber
	 * 
	 * @return tableNumber (int)
	 */
	public int getTableNumber() // Return given Table's number
	{
		return this.tableNumber;
	}

	/**
	 * public int : getTableSize Function to return the given tableSize
	 * 
	 * @return tableSize (int)
	 */
	public int getTableSize() // Return given Table's size
	{
		return this.tableSize;
	}

	/**
	 * public void : setTableSize Function to set the tableSize with a given size
	 * 
	 * @param tableSize (int)
	 */
	public void setTableSize(int tableSize) // To set the size of a new Table
	{
		this.tableSize = tableSize;
	}

	/**
	 * public TableStatus : getTableStatus Function to return the current status of
	 * a given Table
	 * 
	 * @return status (TableStatus)
	 */
	public TableStatus getTableStatus() {
		return status;
	}

	/**
	 * public void : setToEmpty Function to set the given Table's status as EMPTY
	 */
	public void setToEmpty() // To set the Table's status as Empty
	{
		this.status = TableStatus.EMPTY;
	}

	/**
	 * public void : setToOccupied Function to set the given Table's status as
	 * OCCUPIED
	 */
	public void setToOccupied() // To set the Table's status as Occupied
	{
		this.status = TableStatus.OCCUPIED;
	}

	/**
	 * public void : setOrder Function to set the given order to a Table
	 * 
	 * @param order (Order)
	 */
	public void setOrder(Order order) {
		this.tableOrder = order;
	}

	/**
	 * public Order: getOrder Function to return the order for a given Table
	 * 
	 * @return tableOrder (Order)
	 */
	public Order getOrder() {
		return this.tableOrder;
	}

	/**
	 * public void : registerCustomerToTable Function to register the given Customer
	 * to a Table
	 * 
	 * @param waiterName (String)
	 * @param pax        (int)
	 * @param isMember   (boolean)
	 */
	public void registerCustomerToTable(String waiterName, int pax, boolean isMember) {
		this.status = TableStatus.OCCUPIED;
		Calendar currentTime = Calendar.getInstance();
		this.tableOrder = new Order(currentTime, this.tableNumber, pax, waiterName, isMember);
		Restaurant.orderList.add(this.tableOrder);
	}

	/**
	 * public void : settleTable Function to settle and unassign a Table
	 */
	public void settleTable() {
		this.status = TableStatus.EMPTY;
		this.tableOrder = null;

	}

	/**
	 * public ArrayList<Reservation> : getReservationList Function to return the
	 * Reservation list for a given Table.
	 * 
	 * @return tableReservation (ArrayList<Reservation>)
	 */
	public ArrayList<Reservation> getReservationList() {
		return this.tableReservation;
	}

	/**
	 * publiv void : addReservation Function to add a new Reservation to the given
	 * Table
	 * 
	 * @param newReservation (Reservation)
	 */
	public void addReservation(Reservation newReservation) {
		tableReservation.add(newReservation);
	}

	public void removeReservation(int reservationID) {
		Iterator<Reservation> itr = this.tableReservation.iterator();
		while (itr.hasNext()) {
			Reservation reservation = itr.next();
			if (reservation.getReservationID() == reservationID) {
				itr.remove();
			}
		}
	}
}
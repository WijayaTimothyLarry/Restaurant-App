package entityclass;

import java.util.*;

import java.io.Serializable;

public class Order implements Serializable {

	private int orderID;
	private Date orderDate;
	private int tableNumber;
	private String waiterName;
	private ArrayList<OrderItem> orderItems;
	private double totalBill;
	private Invoice invoice;
	// private Reservation reservation;

	public Order(int orderID, Date date, int tableNo, String waitname, ArrayList<OrderItem> itemsOrdered) {
		this.orderID = orderID; // change to hashcode, remove from Order constructor
		this.orderDate = date;
		this.tableNumber = tableNo;
		this.waiterName = waitname;
		this.orderItems = itemsOrdered;
		this.invoice = null;
	}

	public int getOrderID() {
		return this.orderID;
	}

	/**
	 * 
	 * @param orderID
	 */
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	/**
	 * 
	 * @param orderDate
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
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

	public String getWaiterName() {
		return this.waiterName;
	}

	/**
	 * 
	 * @param waiterName
	 */
	public void setWaiterName(String waiterName) {
		this.waiterName = waiterName;
	}

	public ArrayList<OrderItem> getOrderItems() {
		return this.orderItems;
	}

	/**
	 * 
	 * @param orderItems
	 */
	public void setOrderItems(ArrayList<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public double getTotalBill() {
		return this.totalBill;
	}

	/**
	 * 
	 * @param totalBill
	 */
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}

	public void printReciept() {
		// TODO - implement Order.printReciept

	}

	public double calTotalBill() {
		double bill = 0;
		for (int i = 0; i < this.orderItems.size(); i++) {
			bill += this.orderItems.get(i).getPrice();
		}
		return bill;
	}

	public void addOrderItem() {

		if (this.invoice != null)
			return; // lock order for editing when invoice already generated

		int choice;
		int index = 0;
		OrderItem orderItem;
		ArrayList<MenuItem> foodMenu = Menu.getMenuList(); // how to resolve this? static and non-static
		Scanner sc = new Scanner(System.in);
		System.out.println("\nSelect the food item to add to the order:");
		for (MenuItem menuItem : foodMenu)
			System.out.println("(" + index++ + ") " + menuItem.getItemName());
		System.out.println("Enter the number of your choice: ");
		choice = sc.nextInt();
		try {
			String orderItemAdded = foodMenu.get(choice).getItemName();
			orderItem = new OrderItem(foodMenu.get(choice)); // error because of unable to resolve static/non-static
																// issueabove
			this.orderItems.add(orderItem);
			System.out.println(orderItemAdded + " added to order.");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Add order item failed! (Invalid index provided)");
		}

	}

	public void removeOrderItem() {

		if (this.invoice != null)
			return; // lock order for editing when invoice already generated

		int choice, index;
		Scanner sc2 = new Scanner(System.in);
		System.out.println("\nWhat item would you like to remove from the order?");

		index = 0;
		for (OrderItem orderItem : orderItems)
			System.out.println(index++ + ": " + orderItem.getItem().getItemName());
		System.out.println("Enter the number of your choice: ");
		choice = sc2.nextInt();
		try {
			String orderItemRemoved = orderItems.get(choice).toString();
			this.orderItems.remove(choice);
			System.out.println(orderItemRemoved + " removed from order.");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Order item removal failed! (Invalid index provided)");
		}
	}

	// public void generateInvoice(){

	// if(this.invoice != null) return; //lock order for editing when invoice
	// already generated
	// this.invoice = new Invoice(this);
	// this.reservation.getReserveTable().setStatus(TableStatus.VACATED);

	// }

	/**
	 * prints order items in the order's orderlineitems
	 */
	public String toString() {
		String printOrderString = "";
		for (OrderItem o : orderItems) {
			printOrderString += o.getItem().getItemName() + "    " + o.getPrice() + "\n";
		}
		return printOrderString;
	}

}
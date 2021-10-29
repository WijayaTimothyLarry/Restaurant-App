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
	private Reservation reservation;

	public Order(int ident, Date date, int tableNo, String waitname, ArrayList<OrderItem> itemsordered) {
		this.orderID = ident;
		this.orderDate = date;
		this.tableNumber = tableNo;
		this.waiterName = waitname;
		this.orderItems = itemsordered;
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
		// TODO - implement Order.setOrderDate
		throw new UnsupportedOperationException();
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
		throw new UnsupportedOperationException();
	}

	public double calTotalBill(){
		double bill = 0;
		for(int i = 0; i < this.orderItems.size(); i++){
			bill += this.orderItems.get(i).getPrice();
		}
		return bill;
	}

	// 
	//   Calculate the current total order price
	//   @return Order current total price
	 
	// public double calTotalBill(){
	// 	double retPrice = 0;
	// 	for(OrderItem o : this.orderItems)
	// 		retPrice += o.getMenuItem().getPrice();
	// 	return retPrice;
	// }

	public void addOrderItem(){
		
		if(this.invoice != null) return;	//lock order for editing when invoice already generated
		
		int choice;
		int index = 0;
		OrderItem orderItem;
		ArrayList<MenuItem> foodMenu = Restaurant.Menu;
		
		System.out.println("\nSelect the food item to add to the order:");
		for(MenuItem menuItem : foodMenu)
			System.out.println("(" + index++ + ") " + menuItem.getMenuName());
    	choice = ScannerExt.nextInt("    Enter the number of your choice: ");
		
		try {
			String orderItemAdded = foodMenu.get(choice).getMenuName();
			orderItem = new OrderItem(foodMenu.get(choice));
			this.orderItems.add(orderItem);
			System.out.println(orderItemAdded + " added to order."); 
		}catch(IndexOutOfBoundsException e){
			System.out.println("Add order item failed! (Invalid index provided)");
		}

	}

	public void removeOrderItem(){
		
		if(this.invoice != null) return;	//lock order for editing when invoice already generated
		
		int choice, index;
		
		System.out.println("\nWhat item would you like to remove from the order?");
		
		index = 0;
		for (OrderItem orderItem : orderItems)
			System.out.println(index++ + ": " + orderItem.getMenuItem().getMenuName());
    	choice = ScannerExt.nextInt("    Enter the number of your choice: ");
		
		try {
			String orderItemRemoved = orderItems.get(choice).toString();
			this.orderItems.remove(choice);
			System.out.println(orderItemRemoved + " removed from order."); 
		}catch(IndexOutOfBoundsException e){
			System.out.println("Order item removal failed! (Invalid index provided");
		}
	}

	public void generateInvoice(){
		
		if(this.invoice != null) return;	//lock order for editing when invoice already generated
		this.invoice = new Invoice(this);
		this.reservation.getReserveTable().setStatus(TableStatus.VACATED);

	}
	
	
	/**
	 * prints order items in the order's orderlineitems
	 */
	public String toString(){
		String printOrderString = "";
		for(OrderLineItem o : orderLineItems){
			printOrderString += o.getMenuItem().getMenuName() + "    " + o.getChargedPrice() + "\n";
		}
		return printOrderString;
	}

}
package entityclass;

import java.io.Serializable;
import java.util.Calendar;

public class Invoice implements Serializable {

	private Order order;
	private int invoiceID;
	private int tableNumber;
	private double totalBill;
	private OrderItem[] orderItems;
	private String waiterName;
	private double gst;
	private double price;
	private Calendar dateTime;

	public static final double GST = 0.07;
	public Invoice(Order order){
		this.order = order;
		this.invoiceID = Calendar.getInstance().hashCode();
		this.gst = this.price * GST;
		this.price = order.calTotalBill();
		this.totalBill = this.price + this.gst;
		this.dateTime = Calendar.getInstance();
	}

	public Calendar getDatetime() {
		return dateTime;
	}

	/**
	 * 
	 * @param invoiceDateTime
	 */
	public void setDatetime(Calendar invoiceDateTime) {
		this.dateTime = invoiceDateTime;
	}

	public int getInvoiceID() {
		return this.invoiceID;
	}

	/**
	 * 
	 * @param invoiceID
	 */
	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
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

	public OrderItem[] getOrderItems() {
		return this.orderItems;
	}

	/**
	 * 
	 * @param orderItems
	 */
	public void setOrderItems(OrderItem[] orderItems) {
		this.orderItems = orderItems;
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

	public void printInvoice(){
		System.out.println("          RESTAURANT          ");
		System.out.println("******************************");
		System.out.println("Server: " + this.waiterName);
		System.out.println("InvoiceID: " + this.invoiceID);
		System.out.println("Ordered items: " + this.order);
		System.out.println("Subtotal: " + this.price);
		System.out.println("GST: " + this.gst);
		System.out.println("TOTAL: " + this.totalBill);
		System.out.println("******************************");
	}

}
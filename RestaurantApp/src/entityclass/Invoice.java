package entityclass;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import utils.StringUtils;
import java.util.ArrayList;

public class Invoice implements Serializable {

	private Order order;
	/**
	 * (int)ID of the invoice
	 */
	private int invoiceID;
	/**
	 * (int)Table number of the invoice
	 */
	private int tableNumber;
	/**
	 * (double) Total bill of the order
	 */
	private double totalBill;
	/**
	 * (ArrayList<OrderItem>)items ordered by the table
	 */
	private ArrayList<OrderItem> orderItems;
	/**
	 * (String)Name of the waiter serving the table
	 */
	private String waiterName;
	/**
	 * (double)GST according to Singapore Goods and Services Tax
	 */
	private double gst;
	/**
	 * (double)Subtotal of the order made
	 */
	private double subtotal;
	/**
	 * (Date)date when the order is made
	 */
	private Date dateTime;
	/**
	 * (double)Service charge according to Singapore regulations
	 */
	private double SCHARGE;
	/**
	 * (double)Discount given to members
	 */
	private double discount;
	/**
	 * (double)Subtotal after discount
	 */
	private double discountedSubtotal;

	public static final double GST = 0.07; // According to Singapore Goods and Services Tax
	public static final double serviceCharge = 0.10;
	public static final double memDiscount = 0.10;

	/**
	 * Constructor for invoice
	 * 
	 * @param order (Order)Order that invoice is constructed from
	 */
	public Invoice(Order order) {
		this.order = order;
		this.invoiceID = Calendar.getInstance().hashCode(); // Assigning a unique value to an object by hashing
		this.subtotal = order.calTotalBill();
		this.discount = -(this.subtotal * memDiscount);
		this.discountedSubtotal = (this.discount + this.subtotal);
		this.SCHARGE = this.discountedSubtotal * serviceCharge;
		this.gst = (this.SCHARGE + this.discountedSubtotal) * GST;
		this.totalBill = this.discountedSubtotal + this.gst + this.SCHARGE;
		this.dateTime = Calendar.getInstance().getTime();

	}

	/**
	 * Function to return time when the order is made
	 * 
	 * @return (Date)time when the order is made
	 */
	public Date getDatetime() {
		return dateTime;
	}

	/**
	 * Function to set the time when the order is made
	 * 
	 * @param invoiceDateTime (date)time when order is made
	 */
	public void setDatetime(Date invoiceDateTime) {
		this.dateTime = invoiceDateTime;
	}

	/**
	 * Function to return ID of invoice
	 * 
	 * @return (int)ID of invoice
	 */
	public int getInvoiceID() {
		return this.invoiceID;
	}

	/**
	 * Function to set ID of invoice
	 * 
	 * @param invoiceID (int)ID of invoice
	 */
	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}

	/**
	 * Function to get table number
	 * 
	 * @return (int)table number
	 */
	public int getTableNumber() {
		return this.tableNumber;
	}

	/**
	 * Function to set table number
	 * 
	 * @param tableNumber (int)table number
	 */
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}

	/**
	 * Function to get total bill
	 * 
	 * @return (double)total bill
	 */
	public double getTotalBill() {
		return this.totalBill;
	}

	/**
	 * Function to set total bill
	 * 
	 * @param totalBill (double)total bill
	 */
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}

	/**
	 * Function to get the list of items ordered
	 * 
	 * @return (ArrayList<OrderItem>) list of items ordered
	 */
	public ArrayList<OrderItem> getOrderItems() {
		return this.orderItems;
	}

	/**
	 * Function to set the list of items ordered
	 * 
	 * @param orderItems (ArrayList<OrderItem>) list of item ordered
	 */
	public void setOrderItems(ArrayList<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	/**
	 * Function to get the waiter's name
	 * 
	 * @return (String)name of the waiter
	 */
	public String getWaiterName() {
		return this.waiterName;
	}

	/**
	 * Function to set waiter's name
	 * 
	 * @param waiterName (String)Name of the waiter
	 */
	public void setWaiterName(String waiterName) {
		this.waiterName = waiterName;
	}

	/**
	 * Function to print out the entire invoice
	 */
	public void printInvoice() {
		System.out.println("**************************************************");
		System.out.println("                  STEAK & GRILLS                  ");
		System.out.println("**************************************************");
		System.out.println("Service staff: " + this.waiterName);
		System.out.println("Table: " + this.tableNumber);
		System.out.println("Pax: " + order.getPax());
		System.out.println("InvoiceID: " + this.invoiceID);
		System.out.println("Date: " + this.dateTime);
		System.out.println("--------------------------------------------------");
		System.out.println("                      Orders                      ");
		System.out.println("--------------------------------------------------");
		System.out.println("Quantity   " + StringUtils.rightPadding("Order Items", ' ', 20) + "Unit Cost"
				+ StringUtils.leftPadding("Price", ' ', 9));
		System.out.println(order.toString());
		System.out.println("--------------------------------------------------");
		System.out.println("Subtotal: " + StringUtils.leftPadding(String.format("%.2f", this.subtotal), ' ', 40));
		System.out.println("--------------------------------------------------");
		// membership discount
		if (order.getIsMember()) {
			System.out.println("Membership Discount(10%): "
					+ StringUtils.leftPadding(String.format("%.2f", this.discount), ' ', 24));
			System.out.println("Subtotal After Discount: "
					+ StringUtils.leftPadding(String.format("%.2f", this.discountedSubtotal), ' ', 25));
			System.out.println("Service Charge(10%): "
					+ StringUtils.leftPadding(String.format("%.2f", this.discountedSubtotal * 0.10), ' ', 29));
			System.out.println("GST(7%): " + StringUtils.leftPadding(String.format("%.2f", this.gst), ' ', 41));
			System.out.println("--------------------------------------------------");
			System.out.println("TOTAL: " + StringUtils.leftPadding(String.format("%.2f", this.totalBill), ' ', 43));
			System.out.println("--------------------------------------------------");
			System.out.println("TEL : 6737 4411          /  FAX : 6732 2366       ");
			System.out.println("         52 Nanyang Ave, Singapore 639816         ");
			System.out.println("**************************************************\n\n");

		} else {
			System.out.println(
					"Service Charge(10%): " + StringUtils.leftPadding(String.format("%.2f", this.SCHARGE), ' ', 29));
			System.out.println("GST(7%): " + StringUtils.leftPadding(String.format("%.2f", this.gst), ' ', 41));
			System.out.println("--------------------------------------------------");
			System.out.println("TOTAL: " + StringUtils.leftPadding(String.format("%.2f", this.totalBill), ' ', 43));
			System.out.println("--------------------------------------------------");
			System.out.println("TEL : 6737 4411          /  FAX : 6732 2366       ");
			System.out.println("         52 Nanyang Ave, Singapore 639816         ");
			System.out.println("**************************************************\n\n");
		}
	}

}
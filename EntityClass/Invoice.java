import java.time.LocalDateTime;

public class Invoice {

	private LocalDateTime invoiceDateTime;
	private String invoiceID;
	private int tableNumber;
	private double totalBill;
	private OrderItem[] orderItems;
	private String waiterName;

	public LocalDateTime getDatetime() {
		// TODO - implement Invoice.getDatetime
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param invoiceDateTime
	 */
	public void setDatetime(LocalDateTime invoiceDateTime) {
		// TODO - implement Invoice.setDatetime
		throw new UnsupportedOperationException();
	}

	public String getInvoiceID() {
		return this.invoiceID;
	}

	/**
	 * 
	 * @param invoiceID
	 */
	public void setInvoiceID(String invoiceID) {
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

}
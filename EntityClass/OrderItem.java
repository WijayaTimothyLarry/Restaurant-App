import java.io.Serializable;

public class OrderItem implements Serializable {

	private MenuItem item;
	private int quantity;

	public OrderItem() {
		// TODO - implement OrderItem.OrderItem
		throw new UnsupportedOperationException();
	}

	public MenuItem getItem() {
		return this.item;
	}

	/**
	 * 
	 * @param item
	 */
	public void setItem(MenuItem item) {
		this.item = item;
	}

	public int getQuantity() {
		return this.quantity;
	}

	/**
	 * 
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
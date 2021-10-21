package EntityClass;
import java.io.Serializable;

public class OrderItem implements Serializable {

	private MenuItem item;
	private int quantity;

	public OrderItem(MenuItem food, int quant) {
		// TODO - implement OrderItem.OrderItem
		this.item = food;
		this.quantity = quant;
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
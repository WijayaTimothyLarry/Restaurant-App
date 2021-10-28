package entityclass;
import java.io.Serializable;

public class OrderItem implements Serializable {

	private MenuItem item;
	private double price;
	private int quantity;

	public OrderItem(MenuItem food, int quant) {
		// TODO - implement OrderItem.OrderItem
		this.item = food;
		this.quantity = quant;
		this.price = food.getPrice();

		throw new UnsupportedOperationException();
	}

	public double getPrice(){
		return this.price;
	}

	public void setPrice(double price){
		this.price = price;
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
	public String toString(){ return this.getMenuItem().getMenuName(); }

}
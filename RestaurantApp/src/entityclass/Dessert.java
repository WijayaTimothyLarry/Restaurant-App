package entityclass;

public class Dessert extends MenuItem {

	/**
	 * Constructor for Dessert Child Class of MenuItem
	 * 
	 * @param dessertName        (String)Name of MenuItem Dessert
	 * @param dessertPrice       (Double)Price of MenuItem Dessert
	 * @param dessertDescription (String)Description of MenuItem Dessert
	 * @param dessertID          (String)ID of MenuItem Dessert
	 * @see MenuItem
	 */
	public Dessert(String dessertName, double dessertPrice, String dessertDescription, String dessertID) {
		super(dessertName, dessertPrice, dessertDescription, dessertID);
	}
}
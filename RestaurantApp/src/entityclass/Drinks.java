package entityclass;

public class Drinks extends MenuItem {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1265862093162813058L;
	/**
	 * Constructor for MenuItem Drinks
	 * @param drinkName	(String)Name of MenuItem Drinks
	 * @param drinkPrice (Double)Price of MenuItem Drinks
	 * @param drinkDescription	(String)Description of MenuItem Drinks
	 * @param drinkID (String)ID of MenuItem Drinks
	 */

	public Drinks(String drinkName, double drinkPrice, String drinkDescription, String drinkID) {
        super(drinkName, drinkPrice, drinkDescription, drinkID);
    }
}

package entityclass;

public class Appetizer extends MenuItem {

	/**
	 * Constructor for MenuItem - Appetizer Child class of MenuItem
	 * 
	 * @param appeName        (String)Name of MenuItem Appetizer
	 * @param appePrice       (Double)Price of MenuItem Appetizer
	 * @param appeDescription (String)Description of MenuItem Appetizer
	 * @param appeID          (String)ID of MenuItem Appetizer
	 * @see MenuItem
	 */

	public Appetizer(String appeName, double appePrice, String appeDescription, String appeID) {
		super(appeName, appePrice, appeDescription, appeID);
	}
}
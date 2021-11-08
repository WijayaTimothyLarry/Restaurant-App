package entityclass;

public class Appetizer extends MenuItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7202427746854594849L;
	/**
	 * Constructor for MenuItem - Appetizer
	 * @param appeName	(String)Name of MenuItem Appetizer
	 * @param appePrice (Double)Price of MenuItem Appetizer
	 * @param appeDescription (String)Description of MenuItem Appetizer
	 * @param appeID (String)ID of MenuItem Appetizer
	 */

	public Appetizer(String appeName, double appePrice, String appeDescription, String appeID) {
		super(appeName, appePrice, appeDescription, appeID);
	}
}
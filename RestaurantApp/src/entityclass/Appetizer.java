package entityclass;

import java.io.Serializable;

public class Appetizer extends MenuItem implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7202427746854594849L;

	public Appetizer(String appeName, double appePrice, String appeDescription, String appeID) {
        super(appeName,appePrice,appeDescription,appeID);
    }
}
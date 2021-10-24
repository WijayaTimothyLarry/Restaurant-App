package entityclass;

import java.io.Serializable;

public class Drinks extends MenuItem implements Serializable {
    public Drinks(String itemName, double price, String description, String itemID) {
        super(itemName, price, description, itemID);
    }
}

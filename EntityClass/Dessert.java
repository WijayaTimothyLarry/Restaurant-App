package EntityClass;

import java.io.Serializable;

public class Dessert extends MenuItem implements Serializable {

    public Dessert(String itemName, double price, String description, String itemID) {
        super(itemName, price, description, itemID);
    }
}
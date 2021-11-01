package EntityClass;

import java.io.Serializable;

public class Appetizer extends MenuItem implements Serializable {

    Public Appetizer(String itemName, double price, String description, String itemID) {
        super(itemName, price, description, itemID);
    }
}
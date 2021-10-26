package EntityClass;

import java.io.Serializable;

public class Drinks extends MenuItem implements Serializable {
    public Drinks(String drinksName, double drinksPrice, String drinksDescription, String drinksID) {
        super(drinksName,drinksPrice,drinksDescription,drinksID);
    }
}

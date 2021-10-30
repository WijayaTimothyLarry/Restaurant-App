package entityclass;

import java.io.Serializable;

public class Drinks extends MenuItem implements Serializable {
    public Drinks(String drinkName, double drinkPrice, String drinkDescription, String drinkID) {
        super(drinkName,drinkPrice,drinkDescription,drinkID);
    }
}

package entityclass;

import java.io.Serializable;

public class Dessert extends MenuItem implements Serializable {

    public Dessert(String dessertName, double dessertPrice, String dessertDescription, String dessertID) {
        super(dessertName,dessertPrice,dessertDescription,dessertID);
    }
}
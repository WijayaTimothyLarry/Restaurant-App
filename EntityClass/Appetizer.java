package EntityClass;

import java.io.Serializable;

public class Appetizer extends MenuItem implements Serializable {

    public Appetizer(String appeName, double appePrice, String appeDescription, String appeID) {
        super(appeName, appePrice, appeDescription, appeID);
    }
}
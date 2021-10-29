package entityclass;

import java.io.Serializable;

public class MainCourse extends MenuItem implements Serializable {
    public MainCourse(String mcName, double mcPrice, String mcDescription, String mcID) {
        super(mcName,mcPrice,mcDescription,mcID);
    }
}
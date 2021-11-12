import database.Restaurant;

public class initialiseRestaurant {
    /**
     * Function to initialise restaurant app
     * Create and save restaurant
     * @see database.Restaurant
     */
    public static void main(String[] args) {
        Restaurant.createRestaurant();
        Restaurant.saveRestaurant();
    }

}

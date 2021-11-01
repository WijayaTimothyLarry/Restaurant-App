package database;

public class initialiseRestaurant {

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        restaurant.createRestaurant();
        restaurant.saveRestaurant();
    }

}

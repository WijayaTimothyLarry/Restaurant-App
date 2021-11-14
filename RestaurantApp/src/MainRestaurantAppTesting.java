import boundaryclass.MenuInterface;
import boundaryclass.ReservationInterface;
import boundaryclass.SaleRevenueInterface;
import boundaryclass.TableInterface;
import database.Restaurant;
import utils.CustomInput;

public class MainRestaurantAppTesting {

    public static void main(String[] args) {
        Restaurant.createRestaurant();
        int choice;
        boolean on = true;
        while (on) {
            System.out.println("Choose the interface");
            System.out.println("(1) Menu interface");
            System.out.println("(2) Reservation Interface");
            System.out.println("(3) Table Interface");
            System.out.println("(4) Sales Revenue");
            System.out.println("(0) Exit");
            choice = CustomInput.choice(0, 4);

            switch (choice) {
            case 1:
                MenuInterface.showOption();
                break;
            case 2:
                ReservationInterface.showOption();
                break;
            case 3:
                TableInterface.showOption();
                break;
            case 4:
                SaleRevenueInterface.showOption();
                break;
            case 0:
                on = false;
            }
        }
    }
}

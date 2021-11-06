package boundaryclass;

import java.util.Scanner;

import controllerclass.MenuMgr;
import controllerclass.OrderMgr;
import controllerclass.TableMgr;
import entityclass.Order;
import utils.CustomInput;

public class TableInterface {
    private static Scanner scanner = new Scanner(System.in);
    static int choice;

    public static void showOption() {

        System.out.println("(1) Check Table Availability");
        System.out.println("(2) Register customer to table");
        System.out.println("(3) Add order item");
        System.out.println("(4) Settle table");
        choice = scanner.nextInt();
        switch (choice) {
        case 1:
            checkTableAvailability();

        }
    }

    public static void checkTableAvailability() {

    }

    public static void registerCustomerToTable() {
        System.out.println("Enter waiter name:");
        String waiterName = scanner.nextLine();
        System.out.println("Enter Table Number:");
        int tableNumber = CustomInput.nextInt();
        TableMgr.registerCustomerToTable(waiterName, tableNumber);
    }

    public static void addOrderItem() {
        System.out.println("Enter Table Number");
        int tableNumber = CustomInput.nextInt();
        if (!TableMgr.checkTableOcuupied(tableNumber)) {
            System.out.println("There are no customer on this table");
        } else {
            boolean stillAdding = true;
            while (stillAdding) {
                System.out.println("(1) Add Appetizer");
                System.out.println("(2) Add Main Course");
                System.out.println("(3) Add Dessert");
                System.out.println("(4) Add Drinks");
                System.out.println("(5) Add Promo Packages");
                System.out.println("(6) Finish adding");

                choice = CustomInput.choice(0, 5);

                switch (choice) {
                case 1:
                    MenuMgr.showAppetizer();
                    try {
                        System.out.println("Enter appetizer ID:");
                        String itemID = scanner.nextLine();
                        System.out.println("Enter the quantity:");
                        int quantity = CustomInput.nextPositiveInt();
                        OrderMgr.addAppetizer(tableNumber, itemID, quantity);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("The appetizer ID is not recognized");
                    }

                }
            }

        }
    }
}

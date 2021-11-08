package boundaryclass;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import controllerclass.MenuMgr;
import controllerclass.OrderMgr;
import controllerclass.TableMgr;
import entityclass.Table;

import utils.CustomInput;

public class TableInterface {
    private static Scanner scanner = new Scanner(System.in);
    static int choice;

    public static void showOption() {
        boolean on = true;

        while(on){
            System.out.println("(1) Check Table Availability");
            System.out.println("(2) Register customer to table");
            System.out.println("(3) Print a table's order");
            System.out.println("(4) Add order item");
            System.out.println("(5) Remove order item");
            System.out.println("(6) Settle table");
            System.out.println("(0) Exit ");
            choice = scanner.nextInt();
            choice = CustomInput.choice(0, 6);
            switch (choice) {
            case 1:
                checkTableAvailability();
            case 2:
                registerCustomerToTable();
            case 3:
                printTableOrder();
            case 4:
                addOrderItem();
            case 5:
                removeOrderItem();
            case 6:
                settleTable();
            case 0:
                on = false;
            }
        }

        }

    public static void checkTableAvailability() {
        System.out.println("Enter number of pax:");
        int noOfPax = CustomInput.nextPositiveInt();
        Calendar currentTime = Calendar.getInstance();
        ArrayList<Table> availableTable = TableMgr.getAvailableTables(noOfPax, currentTime);
        if (availableTable.isEmpty())
            System.out.println("There are no available table");
        else {
            System.out.println("List of available table");
            for (Table table : availableTable) {
                System.out.printf("Table %d /n", table.getTableNumber());
            }
            System.out.println("");
        }

    }

    public static void registerCustomerToTable() {
        System.out.println("Enter waiter name:");
        String waiterName = scanner.nextLine();
        System.out.println("Enter Table Number:");
        int tableNumber = CustomInput.nextPositiveInt();
        TableMgr.registerCustomerToTable(waiterName, tableNumber);
    }

    public static void printTableOrder() {
        System.out.println("Enter Table Number");
        int tableNumber = CustomInput.nextPositiveInt();
        OrderMgr.printTableOrder(tableNumber);
    }

    public static void addOrderItem() {
        System.out.println("Enter Table Number");
        int tableNumber = CustomInput.nextInt();
        if (!TableMgr.checkTableOccupied(tableNumber)) {
            System.out.println("There are no customer on this table");
        } else {
            boolean stillAdding = true;
            while (stillAdding) {
                System.out.println("(1) Add Appetizer");
                System.out.println("(2) Add Main Course");
                System.out.println("(3) Add Dessert");
                System.out.println("(4) Add Drinks");
                System.out.println("(5) Add Promo Packages");
                System.out.println("(0) Finish adding");

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
                    break;

                case 2:
                    MenuMgr.showMainCourse();
                    try {
                        System.out.println("Enter Main Course ID:");
                        String itemID = scanner.nextLine();
                        System.out.println("Enter the quantity:");
                        int quantity = CustomInput.nextPositiveInt();
                        OrderMgr.addMainCourse(tableNumber, itemID, quantity);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("The Main Course ID is not recognized");
                    }
                    break;

                case 3:
                    MenuMgr.showDessert();
                    try {
                        System.out.println("Enter Dessert ID:");
                        String itemID = scanner.nextLine();
                        System.out.println("Enter the quantity:");
                        int quantity = CustomInput.nextPositiveInt();
                        OrderMgr.addDessert(tableNumber, itemID, quantity);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("The Dessert ID is not recognized");
                    }
                    break;

                case 4:
                    MenuMgr.showDrinks();
                    try {
                        System.out.println("Enter Drinks ID:");
                        String itemID = scanner.nextLine();
                        System.out.println("Enter the quantity:");
                        int quantity = CustomInput.nextPositiveInt();
                        OrderMgr.addDrinks(tableNumber, itemID, quantity);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("The Drink ID is not recognized");
                    }
                    break;

                case 5:
                    MenuMgr.showDessert();
                    try {
                        System.out.println("Enter Promo Package ID:");
                        String itemID = scanner.nextLine();
                        System.out.println("Enter the quantity:");
                        int quantity = CustomInput.nextPositiveInt();
                        OrderMgr.addPackage(tableNumber, itemID, quantity);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("The Promo Package ID is not recognized");
                    }
                    break;

                case 0:
                    stillAdding = false;
                }
            }

        }
    }

    public static void removeOrderItem(){
        System.out.println("Enter Table Number:");
        int tableNumber = CustomInput.nextPositiveInt();
        if (!TableMgr.checkTableOccupied(tableNumber)) {
            System.out.println("There are no customer on this table");
        } else {
            boolean stillRemoving = true;
            while (stillRemoving) {
                System.out.println("(1) Remove an Order Item");
                System.out.println("(0) Finish Removing");

                choice = CustomInput.choice(0, 1);

                switch (choice) {
                case 1:
                    OrderMgr.printTableOrder(tableNumber);
                    OrderMgr.removeOrder(tableNumber);
                    break;
                case 0:
                    stillRemoving = false;
            }
        }
    }
    }

    public static void settleTable(){
        System.out.println("Enter Table Number:");
        int tableNumber = CustomInput.nextPositiveInt();
        TableMgr.unassignTable(tableNumber);
    }
}

package boundaryclass;

import java.util.Scanner;

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

    }
}

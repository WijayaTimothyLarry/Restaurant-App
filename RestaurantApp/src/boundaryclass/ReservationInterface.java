package boundaryclass;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import controllerclass.ReservationMgr;
import entityclass.Reservation;
import entityclass.Table;
import utils.CustomInput;

public class ReservationInterface {
    /**
     * Scanner object to receive customer's input in the interface
     */
    private static Scanner scanner = new Scanner(System.in);

    /**
     * choice of customer's selection
     */
    static int choice;

    public static void showOption() {

        boolean on = true;
        ReservationMgr.removeExpiredReservation();
        while (on) {
            System.out.println("(1) Check Customer Reservation");
            System.out.println("(2) Check Table Reservation(s)");
            System.out.println("(3) Create New Reservation");
            System.out.println("(4) Remove Customer Reservation");
            System.out.println("(0) Go back");
            choice = CustomInput.choice(0, 4);
            switch (choice) {
            case 1:
                checkCustomerReservation();
                break;
            case 2:
                checkTableReservation();
                break;
            case 3:
                createNewReservation();
                break;
            case 4:
                removeCustomerReservation();
                break;
            case 0:
                on = false;

            }
        }
        System.err.println("");

    }

    /**
     * private static void : checkCustomerReservation Function to start checking if
     * a reservation exists for the given customer based on the customer's phone
     * number
     */
    private static void checkCustomerReservation() {
        String phoneNumber = CustomInput.phoneNumberInput();
        Reservation reservation = ReservationMgr.checkCustomerReservation(phoneNumber);
        if (reservation == null) {
            System.out.println("There are no reservation for this customer\n");
        } else {
            System.out.println("Customer reservation information:\n");
            reservation.printReservationInfo();
        }

    }

    /**
     * private static void : checkTableReservation Function to check if Reservations
     * exist for the given tablenumber
     * 
     * @param tableNumber (int) Number of the table to check reservation for
     */
    private static void checkTableReservation() {
        System.out.println("Enter Table Number:");
        int tableNumber = CustomInput.nextPositiveInt();
        ArrayList<Reservation> reservationList = ReservationMgr.checkTableReservation(tableNumber);
        if (reservationList == null) {
            System.out.println("\nPlease enter a valid table number\n");
        } else {
            if (reservationList.size() == 0)
                System.out.println("There are no reservation for this table\n");
            else {
                System.out.printf("Table %d Reservation(s):\n\n", tableNumber);
                for (Reservation reservation : reservationList) {
                    reservation.printReservationInfo();
                }
            }
        }
    }

    /**
     * private static void : createNewReservation Function to create a new
     * Reservation based on the customer's phone number, name, number of pax, table
     * number and the reservation's date and time.
     */
    private static void createNewReservation() {
        String phoneNumber = CustomInput.phoneNumberInput();
        Reservation reservation = ReservationMgr.checkCustomerReservation(phoneNumber);
        if (reservation != null) {
            System.out.println("Customer already have the following reservation:");
            reservation.printReservationInfo();
            return;
        }
        System.out.println("Enter Customer Name");
        String customerName = scanner.nextLine();
        System.out.println("Enter the date and time of reservation");
        Calendar reservationDate = CustomInput.dateInput();
        System.out.println("Enter the total number of people for this Reservation");
        int newNoOfPax = CustomInput.nextPositiveInt();
        ArrayList<Table> availableTable = ReservationMgr.getAvailableTables(newNoOfPax, reservationDate);
        if (availableTable.isEmpty()) {
            System.out.println("There are no available table for this timing");
        }
        System.out.println("Available table:");
        for (Table table : availableTable) {
            System.out.printf("Table %d, table size = %d\n", table.getTableNumber(), table.getTableSize());
        }
        System.out.println("\nEnter table number to be reserved");
        int tableNumber = CustomInput.nextPositiveInt();
        ReservationMgr.newReservation(phoneNumber, reservationDate, customerName, newNoOfPax, tableNumber);
    }

    private static void removeCustomerReservation() {
        System.out.println("Enter customer phone number:");
        String phoneNumber = CustomInput.phoneNumberInput();
        Reservation reservation = ReservationMgr.checkCustomerReservation(phoneNumber);
        if (reservation == null) {
            System.out.println("There are no reservation for this customer");
        } else {
            System.out.println("The following reservation will be removed:");
            reservation.printReservationInfo();
            System.out.println("Insert 1 to confirm");
            int confirmation = CustomInput.nextInt();
            if (confirmation == 1) {
                ReservationMgr.removeReservation(phoneNumber);
                System.out.println("Reservation has been removed");
            }
        }
    }
}

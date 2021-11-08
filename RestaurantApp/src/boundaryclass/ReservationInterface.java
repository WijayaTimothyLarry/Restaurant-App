package boundaryclass;

import java.util.Scanner;

import controllerclass.ReservationMgr;
import entityclass.Reservation;

public class ReservationInterface {
    private static Scanner scanner = new Scanner(System.in);
    static int choice;

    public static void showOption() {

        System.out.println("(1) Check Customer Reservation");
        System.out.println("(2) Create New Reservation");
        System.out.println("(3) Remove Customer Reservation");
        System.out.println("(0) Exit");
        boolean on = true;
        choice = scanner.nextInt();
        while(on){
            switch (choice) {
                case 1:
                    checkCustomerReservation();
                    break;
                case 2:
                    createNewReservation();
                    break;
                case 3:
                    removeCustomerReservation();
                    break;
                case 0:
                    on = false;
                    break;
                }
        }


    }

    private static void checkCustomerReservation() {
        System.out.println("Enter customer phone number:");
        String phoneNumber = scanner.nextLine();
        Reservation reservation = ReservationMgr.checkCustomerReservation(phoneNumber);
        if (reservation == null) {
            System.out.println("There are no reservation for this customer");
        } else {
            System.out.println("Customer reservation information:");
            reservation.printReservationInfo();
        }

    }

    private static void createNewReservation() {
        System.out.println("Enter customer phone number:");
        String phoneNumber = scanner.nextLine();
        while (phoneNumber.length() == 8 && (phoneNumber.charAt(0) == 9 || phoneNumber.charAt(0) == 8)) {
        Reservation reservation = ReservationMgr.checkCustomerReservation(phoneNumber);
        if (reservation != null) {
            System.out.println("Customer already have the following reservation:");
            reservation.printReservationInfo();
        } else {
            ReservationMgr.newReservation(phoneNumber);
        }
    }
    }

    private static void removeCustomerReservation() {
        System.out.println("Enter customer phone number:");
        String phoneNumber = scanner.nextLine();
        Reservation reservation = ReservationMgr.checkCustomerReservation(phoneNumber);
        if (reservation == null) {
            System.out.println("There are no reservation for this customer");
        } else {
            System.out.println("The following reservation will be removed:");
            reservation.printReservationInfo();
            System.out.println("Insert 1 to confirm");
            int confirmation = scanner.nextInt();
            if (confirmation == 1) {
                ReservationMgr.removeReservation(phoneNumber);
                System.out.println("Reservation has been removed");
            }
        }
    }
}

package controllerclass;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Scanner;

import database.Restaurant;
import entityclass.Reservation;

public class ReservationMgr {

    private TableMgr tableCtrl = new TableMgr();
    private static ArrayList<Reservation> reservationList = Restaurant.reservationList;
    private Scanner sc = new Scanner(System.in);

    public ReservationMgr() {

    }

    public void setTableMgr(TableMgr tableCtrl) {
        this.tableCtrl = tableCtrl;
    }

    public void newReservation() {
        String newCustomerContactNo;

        System.out.println("Enter Customer's contact Number to make Reservation");
        newCustomerContactNo = sc.next();
        while (newCustomerContactNo.length() == 8 && ( newCustomerContactNo.charAt(0) == 9 || newCustomerContactNo.charAt(0) == 8)) 
        {
            if(checkCustomerReservation(newCustomerContactNo) != null)    break;
        }

        LocalDate newReservDate = checkReservDate();

        LocalTime newArrivalTime = checkReservTime();
        //newReservDateTime.set(Calendar.YEAR, Calendar.MONTH, Calendar.DATE, Calendar.HOUR_OF_DAY, Calendar.MINUTE);

        
        int newNoOfPax;

        System.out.println("Enter the total number of people under Reservation");
        newNoOfPax = sc.nextInt();
        while (newNoOfPax == (int) newNoOfPax) {
            ArrayList<Integer> tableNumbers = tableCtrl.getAvailTableNoByPax(newNoOfPax);

            if (tableNumbers.isEmpty()) {
                System.out.println("All tables are Reserved");
            }

            else {
                System.out.println("Enter Customer Name:");
                String newCustomerName = sc.next();
                Reservation newReserv = new Reservation(newDateTime, newCustomerName,newCustomerContactNo, newNoOfPax, tableNumbers.get(0));

                reservationList.add(newReserv);
                startReservationTimer(newReserv);
                System.out.println("New Reservation successfully made for Table Number: " + newReserv.getTableNumber());

            }
        }
    }

    private void startReservationTimer(Reservation newReserv) {

    }

    private LocalTime checkReservTime() {
        return null;
    }

    private LocalDate checkReservDate() {
        return null;
    }


    public static Reservation checkCustomerReservation(String phoneNumber) {
        for (Reservation reservation : reservationList) {
            if (reservation.getCustomerContactNo().equals(phoneNumber)) {
                return reservation;
            }
        }
        return null;
    }

    public static void removeReservation(String phoneNumber) {
        Iterator<Reservation> itr = reservationList.iterator();
        while (itr.hasNext()) {
            Reservation reservation = itr.next();
            if (reservation.getCustomerContactNo().equals(phoneNumber)) {
                itr.remove();
            }
        }
    }

}

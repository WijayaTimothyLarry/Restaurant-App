package controllerclass;

import java.util.ArrayList;
import java.util.Calendar;

import entityclass.Invoice;
import database.Restaurant;

public class SaleRevenueMgr {
    private static ArrayList<Invoice> invoiceList = Restaurant.invoiceList;

    public static void printDailyRevenue(Calendar date) {
        ArrayList<Invoice> dailyInvoices = new ArrayList<Invoice>();
        for (Invoice invoice : invoiceList) {
            date.get(Calendar.DAY_OF_MONTH);

        }
    }

    public static void printMonthlyRevenue(Calendar date) {

    }

    public static void printYearlyRevenue(Calendar date) {

    }
}

package controllerclass;

import java.util.ArrayList;
import java.util.Calendar;

import entityclass.Invoice;
import utils.CustomInput;
import database.Restaurant;

public class SaleRevenueMgr {
    /**
     * ArrayList<Invoice> list of all invoices under the restaurant
     */
    private static ArrayList<Invoice> invoiceList = Restaurant.invoiceList;

    /**
     * public static : getDailyRevenue
     * Function to return the revenue of the restaurant for the given date
     * @param date (Calendar) date revenue of the restaurant being requested for 
     * @return daySaleRevenue (double) based on accumulating all the invoices under the restaurant for the given date
     */
    public static double getDailyRevenue(Calendar date) {
        double daySaleRevenue = 0;
        for (Invoice invoice : invoiceList) {
            if (CustomInput.compareDMY(date.getTime(), invoice.getDatetime())) {
                daySaleRevenue += invoice.getTotalBill();
            }
        }
        return daySaleRevenue;
    }

    /**
     * public static double : getMonthlyRevenue
     * Function to return monthly revenue for the given date
     * @param date (Calendar)
     * @return monthSaleRevenue (double) by accumulating all invoices in the month for the given date 
     */
    public static double getMonthlyRevenue(Calendar date) {
        double monthSaleRevenue = 0;
        for (Invoice invoice : invoiceList) {
            if (CustomInput.compareMY(date.getTime(), invoice.getDatetime())) {
                monthSaleRevenue += invoice.getTotalBill();
            }
        }
        return monthSaleRevenue;
    }

    /**
     * public static double : getYearlyRevenue
     * Function to return the yearly revenue for the given date
     * @param date (Calendar) date of the yearly revenue to be returned
     * @return yearSaleRevenue (double) of the accumulated invoices of the given year. 
     */
    public static double getYearlyRevenue(Calendar date) {
        double yearSaleRevenue = 0;
        for (Invoice invoice : invoiceList) {
            if (CustomInput.compareY(date.getTime(), invoice.getDatetime())) {
                yearSaleRevenue += invoice.getTotalBill();
            }
        }
        return yearSaleRevenue;
    }
}

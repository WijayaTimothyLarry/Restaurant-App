package controllerclass;

import java.util.ArrayList;
import java.util.Calendar;

import entityclass.Invoice;
import utils.CustomInput;
import database.Restaurant;

public class SaleRevenueMgr {
    private static ArrayList<Invoice> invoiceList = Restaurant.invoiceList;

    public static double getDailyRevenue(Calendar date) {
        double daySaleRevenue = 0;
        for (Invoice invoice : invoiceList) {
            if (CustomInput.compareDMY(date.getTime(), invoice.getDatetime())) {
                daySaleRevenue += invoice.getTotalBill();
            }
        }
        return daySaleRevenue;
    }

    public static double getMonthlyRevenue(Calendar date) {
        double monthSaleRevenue = 0;
        for (Invoice invoice : invoiceList) {
            if (CustomInput.compareMY(date.getTime(), invoice.getDatetime())) {
                monthSaleRevenue += invoice.getTotalBill();
            }
        }
        return monthSaleRevenue;
    }

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

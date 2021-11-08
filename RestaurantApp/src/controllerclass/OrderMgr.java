package controllerclass;

import java.util.ArrayList;

import database.Restaurant;
import entityclass.Appetizer;
import entityclass.Dessert;
import entityclass.Drinks;
import entityclass.MainCourse;
import entityclass.Menu;
import entityclass.Order;
import entityclass.OrderItem;
import entityclass.PackageItem;

public class OrderMgr {
    static ArrayList<Order> orderList = Restaurant.orderList;
    static Menu restaurantMenu = Restaurant.restaurantMenu;

    public static void printTableOrder(int tableNumber) {
        Order tableOrder = getTableOrder(tableNumber);
        if (tableOrder == null) {
            System.out.println("There is no order for this table");
        } else {
            System.out.printf("Table %d Order\n", tableNumber);
            System.out.println(tableOrder.toString());
        }
    }

    public static void addAppetizer(int tableNumber, String itemID, int quantity) {
        Order tableOrder = getTableOrder(tableNumber);
        if (tableOrder == null) {
            System.out.println("There is no customer in this table");
        } else {
            Appetizer appetizer = restaurantMenu.getAppeList().get(restaurantMenu.findforAppeList(itemID));
            OrderItem newItem = new OrderItem(appetizer, quantity);
            tableOrder.addOrderItem(newItem);
        }
    }

    public static void addMainCourse(int tableNumber, String itemID, int quantity) {
        Order tableOrder = getTableOrder(tableNumber);
        if (tableOrder == null) {
            System.out.println("There is no customer in this table");
        } else {
            MainCourse mainCourse = restaurantMenu.getMainCourseList()
                    .get(restaurantMenu.findforMainCourseList(itemID));
            OrderItem newItem = new OrderItem(mainCourse, quantity);
            tableOrder.addOrderItem(newItem);
        }
    }

    public static void addDessert(int tableNumber, String itemID, int quantity) {
        Order tableOrder = getTableOrder(tableNumber);
        if (tableOrder == null) {
            System.out.println("There is no customer in this table");
        } else {
            Dessert dessert = restaurantMenu.getDessertList().get(restaurantMenu.findforDessertList(itemID));
            OrderItem newItem = new OrderItem(dessert, quantity);
            tableOrder.addOrderItem(newItem);
        }
    }

    public static void addDrinks(int tableNumber, String itemID, int quantity) {
        Order tableOrder = getTableOrder(tableNumber);
        if (tableOrder == null) {
            System.out.println("There is no customer in this table");
        } else {
            Drinks drinks = restaurantMenu.getDrinksList().get(restaurantMenu.findforDrinksList(itemID));
            OrderItem newItem = new OrderItem(drinks, quantity);
            tableOrder.addOrderItem(newItem);
        }
    }

    public static void addPackage(int tableNumber, String itemID, int quantity) {
        Order tableOrder = getTableOrder(tableNumber);
        if (tableOrder == null) {
            System.out.println("There is no customer in this table");
        } else {
            PackageItem packageItem = restaurantMenu.getPackagesList().get(restaurantMenu.findforPackageList(itemID));
            OrderItem newItem = new OrderItem(packageItem, quantity);
            tableOrder.addOrderItem(newItem);
        }
    }

    public static Order getTableOrder(int tableNumber) {
        for (Order order : orderList) {
            if (order.getTableNumber() == tableNumber)
                return order;
        }
        return null;
    }

    public static void removeOrder(int tableNumber) {
        Order tableOrder = getTableOrder(tableNumber);
        if (tableOrder == null) {
            System.out.println("There is no customer in this table");
        } else {
            tableOrder.removeOrderItem();
        }
    }
}

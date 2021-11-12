package controllerclass;

import java.util.ArrayList;
import java.util.Iterator;

import database.Restaurant;
import entityclass.Appetizer;
import entityclass.Dessert;
import entityclass.Drinks;
import entityclass.MainCourse;
import entityclass.Menu;
import entityclass.MenuItem;
import entityclass.Order;
import entityclass.OrderItem;
import entityclass.PackageItem;

public class OrderMgr {
    /**
     * Static list of Order Made by Table
     */
    static ArrayList<Order> orderList = Restaurant.orderList;
    /**
     * Static list of Menu of the Restaurant
     */
    static Menu restaurantMenu = Restaurant.restaurantMenu;

    /**
     * Function to print the order of a table based on tablenumber
     * 
     * @param tableNumber (int)tableNumber of the table which order is printed
     */
    public static void printTableOrder(int tableNumber) {
        Order tableOrder = getTableOrder(tableNumber);
        if (tableOrder == null) {
            System.out.println("There is no order for this table\n");
        } else {
            System.out.printf("Table %d Order\n", tableNumber);
            System.out.println(tableOrder.toString());
        }
    }

    /**
     * Function to add an Appetizer to the order of a table based on tableNumber
     * 
     * @param tableNumber (int)Table Number of the table which order is added
     * @param itemID      (String)ID of the Appetizer
     * @param quantity    (int)Quantity of appetizer ordered
     */
    public static void addAppetizer(int tableNumber, String itemID, int quantity) {
        Order tableOrder = getTableOrder(tableNumber);
        if (tableOrder == null) {
            System.out.println("There is no customer in this table\n");
        } else {
            Appetizer appetizer = restaurantMenu.getAppeList().get(restaurantMenu.findforAppeList(itemID));
            OrderItem newItem = new OrderItem(appetizer, quantity);
            tableOrder.addOrderItem(newItem);
        }
    }

    /**
     * Function to add a Main Course to the order of a table based on tableNumber
     * 
     * @param tableNumber (int)Table Number of the table which order is added
     * @param itemID      (String)ID of the MainCourse
     * @param quantity    (int)Quantity of MainCourse ordered
     */
    public static void addMainCourse(int tableNumber, String itemID, int quantity) {
        Order tableOrder = getTableOrder(tableNumber);
        if (tableOrder == null) {
            System.out.println("There is no customer in this table\n");
        } else {
            MainCourse mainCourse = restaurantMenu.getMainCourseList()
                    .get(restaurantMenu.findforMainCourseList(itemID));
            OrderItem newItem = new OrderItem(mainCourse, quantity);
            tableOrder.addOrderItem(newItem);
        }
    }

    /**
     * Function to add a Dessert to the order of a table based on tableNumber
     * 
     * @param tableNumber (int)Table Number of the table which order is added
     * @param itemID      (String)ID of the Dessert
     * @param quantity    (int)Quantity of Dessert ordered
     */
    public static void addDessert(int tableNumber, String itemID, int quantity) {
        Order tableOrder = getTableOrder(tableNumber);
        if (tableOrder == null) {
            System.out.println("There is no customer in this table\n");
        } else {
            Dessert dessert = restaurantMenu.getDessertList().get(restaurantMenu.findforDessertList(itemID));
            OrderItem newItem = new OrderItem(dessert, quantity);
            tableOrder.addOrderItem(newItem);
        }
    }

    /**
     * Function to add a Drinks item to the order of a table based on tableNumber
     * 
     * @param tableNumber (int)Table Number of the table which order is added
     * @param itemID      (String)ID of the Drinks
     * @param quantity    (int)Quantity of Drinks ordered
     */
    public static void addDrinks(int tableNumber, String itemID, int quantity) {
        Order tableOrder = getTableOrder(tableNumber);
        if (tableOrder == null) {
            System.out.println("There is no customer in this table\n");
        } else {
            Drinks drinks = restaurantMenu.getDrinksList().get(restaurantMenu.findforDrinksList(itemID));
            OrderItem newItem = new OrderItem(drinks, quantity);
            tableOrder.addOrderItem(newItem);
        }
    }

    /**
     * Function to add a PackageItem to the order of a table based on tableNumber
     * 
     * @param tableNumber (int)Table Number of the table which order is added
     * @param itemID      (String)ID of the PromoPackage
     * @param quantity    (int)Quantity of the Package ordered
     */
    public static void addPackage(int tableNumber, String itemID, int quantity) {
        Order tableOrder = getTableOrder(tableNumber);
        if (tableOrder == null) {
            System.out.println("There is no customer in this table\n");
        } else {
            PackageItem packageItem = restaurantMenu.getPackagesList().get(restaurantMenu.findforPackageList(itemID));
            OrderItem newItem = new OrderItem(packageItem, quantity);
            tableOrder.addOrderItem(newItem);
        }
    }

    /**
     * Function to retrieve order of the Table based on tableNumber
     * 
     * @param tableNumber Number of the table that we are checking
     * @return (Order)order of the table; null if no order is attached to the table
     */
    public static Order getTableOrder(int tableNumber) {
        for (Order order : orderList) {
            if (order.getTableNumber() == tableNumber)
                return order;
        }
        return null;
    }

    public static void removeOrderItem(int tableNumber, String itemID) {
        Order tableOrder = getTableOrder(tableNumber);
        ArrayList<OrderItem> orderItems = tableOrder.getOrderItems();
        Iterator<OrderItem> itr = orderItems.iterator();
        while (itr.hasNext()) {
            MenuItem menuItem = itr.next().getItem();
            if (menuItem.getItemID().equals(itemID)) {
                itr.remove();
                return;
            }
        }
        System.out.println("There is no order item with this item ID\n");
    }
}

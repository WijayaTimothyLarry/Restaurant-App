package controllerclass;

import database.Restaurant;
import entityclass.*;

public class MenuMgr {
    private static Menu restaurantMenu = Restaurant.restaurantMenu;

    public static void showAppetizer() {
        restaurantMenu.printAppeList();
    }

    public static void showMainCourse() {
        restaurantMenu.printMainCourse();
    }

    public static void showDessert() {
        restaurantMenu.printDessert();
    }

    public static void showDrinks() {
        restaurantMenu.printDrinks();
    }

    public static void showPackage() {
        restaurantMenu.printPackage();
    }

    // Functions to edit menu
    // 1) Adding into menu
    // Appetizer
    public static void addAppe(Appetizer appe) {
        restaurantMenu.addintoAppeList(appe);
    }

    // Main Course
    public static void addMainCourse(MainCourse maincourse) {
        restaurantMenu.addintoMainCourseList(maincourse);
    }

    // Dessert
    public static void addDessert(Dessert dessert) {
        restaurantMenu.addintoDessertList(dessert);
    }

    // Drinks
    public static void addDrinks(Drinks drinks) {
        restaurantMenu.addintoDrinksList(drinks);
    }

    // Package
    public static void addPackage(PackageItem packages) {
        restaurantMenu.addintoPackageList(packages);
    }

    // 2) Delete item
    // Appetizer
    public static void removeAppetizer(String id) {
        if (restaurantMenu.removeforAppeList(id) == -1) {
            System.out.println("Item not found");
        }
    }

    // MainCourse
    public static void removeMainCourse(String id) {
        if (restaurantMenu.removeforMainCourseList(id) == -1) {
            System.out.println("Item not found");
        }
    }

    // Dessert
    public static void removeDessert(String id) {
        if (restaurantMenu.removeforDessertList(id) == -1) {
            System.out.println("Item not found");
        }
    }

    // Drinks
    public static void removeDrinks(String id) {
        if (restaurantMenu.removeforDrinksList(id) == -1) {
            System.out.println("Item not found");
        }
    }

    // Packages
    public static void removePackage(String id) {
        if (restaurantMenu.removeforPackageList(id) == -1) {
            System.out.println("Item not found");
        }
    }

}
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

    public void showMenu(){
        restaurantMenu.printMenu();
    }

    // Functions to edit menu
    // 1) Adding into menu
    // Appetizer
    public static void addAppe(Appetizer appe) {
        restaurantMenu.addintoAppeList(appe);
        restaurantMenu.addintoMenuList(appe);
    }

    // Main Course
    public static void addMainCourse(MainCourse maincourse) {
        restaurantMenu.addintoMainCourseList(maincourse);
        restaurantMenu.addintoMenuList(maincourse);
    }

    // Dessert
    public static void addDessert(Dessert dessert) {
        restaurantMenu.addintoDessertList(dessert);
        restaurantMenu.addintoMenuList(dessert);
    }

    // Drinks
    public static void addDrinks(Drinks drinks) {
        restaurantMenu.addintoDrinksList(drinks);
        restaurantMenu.addintoMenuList(drinks);
    }

    // Package
    public static void addPackage(PackageItem packages) {
        restaurantMenu.addintoPackageList(packages);
        restaurantMenu.addintoMenuList(packages);
    }

    // 2) Delete item
    // Appetizer
    public static void removeAppetizer(String id) {
        if (restaurantMenu.removeforAppeList(id) == -1) {
            System.out.println("Item not found");
        }else{
            restaurantMenu.removeforMenuList(id);
        }
    }

    // MainCourse
    public static void removeMainCourse(String id) {
        if (restaurantMenu.removeforMainCourseList(id) == -1) {
            System.out.println("Item not found");
        }else{
            restaurantMenu.removeforMenuList(id);
        }
    }

    // Dessert
    public static void removeDessert(String id) {
        if (restaurantMenu.removeforDessertList(id) == -1) {
            System.out.println("Item not found");
        }else{
            restaurantMenu.removeforMenuList(id);
        }
    }

    // Drinks
    public static void removeDrinks(String id) {
        if (restaurantMenu.removeforDrinksList(id) == -1) {
            System.out.println("Item not found");
        }else{
            restaurantMenu.removeforMenuList(id);
        }
    }

    // Packages
    public static void removePackage(String id) {
        if (restaurantMenu.removeforPackageList(id) == -1) {
            System.out.println("Item not found");
        }else{
            restaurantMenu.removeforMenuList(id);
        }
    }

}
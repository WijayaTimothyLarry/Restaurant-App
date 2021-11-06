package controllerclass;

import database.Restaurant;
import entityclass.*;

public class MenuMgr {
    private static Menu restaurantMenu = Restaurant.restaurantMenu;

    public static void showAppetizer() {
        restaurantMenu.printAppeList();
    }

    public void showMainCourse() {
        restaurantMenu.printMainCourse();
    }

    public void showDessert() {
        restaurantMenu.printDessert();
    }

    public void showDrinks() {
        restaurantMenu.printDrinks();
    }

    public void showPackage() {
        restaurantMenu.printPackage();
    }

    public void showMenu(){
        restaurantMenu.printMenu();
    }

    // Functions to edit menu
    // 1) Adding into menu
    // Appetizer
    public void addAppe(Appetizer appe) {
        restaurantMenu.addintoAppeList(appe);
        restaurantMenu.addintoMenuList(appe);
    }

    // Main Course
    public void addMainCourse(MainCourse maincourse) {
        restaurantMenu.addintoMainCourseList(maincourse);
        restaurantMenu.addintoMenuList(maincourse);
    }

    // Dessert
    public void addDessert(Dessert dessert) {
        restaurantMenu.addintoDessertList(dessert);
        restaurantMenu.addintoMenuList(dessert);
    }

    // Drinks
    public void addDrinks(Drinks drinks) {
        restaurantMenu.addintoDrinksList(drinks);
        restaurantMenu.addintoMenuList(drinks);
    }

    // Package
    public void addPackage(PackageItem packages) {
        restaurantMenu.addintoPackageList(packages);
        restaurantMenu.addintoMenuList(packages);
    }

    // 2) Delete item
    // Appetizer
    public void removeAppe(String id) {
        if (restaurantMenu.removeforAppeList(id) == -1) {
            System.out.println("Item not found");
        }else{
            restaurantMenu.removeforMenuList(id);
        }
    }

    // MainCourse
    public void removeMainCourse(String id) {
        if (restaurantMenu.removeforMainCourseList(id) == -1) {
            System.out.println("Item not found");
        }else{
            restaurantMenu.removeforMenuList(id);
        }
    }

    // Dessert
    public void removeDessert(String id) {
        if (restaurantMenu.removeforDessertList(id) == -1) {
            System.out.println("Item not found");
        }else{
            restaurantMenu.removeforMenuList(id);
        }
    }

    // Drinks
    public void removeDrinks(String id) {
        if (restaurantMenu.removeforDrinksList(id) == -1) {
            System.out.println("Item not found");
        }else{
            restaurantMenu.removeforMenuList(id);
        }
    }

    // Packages
    public void removePackage(String id) {
        if (restaurantMenu.removeforPackageList(id) == -1) {
            System.out.println("Item not found");
        }else{
            restaurantMenu.removeforMenuList(id);
        }
    }

}
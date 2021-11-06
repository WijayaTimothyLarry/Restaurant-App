package boundaryclass;

import java.util.Scanner;

import controllerclass.MenuMgr;
import entityclass.Appetizer;
import entityclass.Dessert;
import entityclass.Drinks;
import entityclass.MainCourse;
import utils.CustomInput;

public class MenuInterface {
    private Scanner scanner = new Scanner(System.in);
    int choice;

    public void showOption() {

        System.out.println("(1) Display Menu");
        System.out.println("(2) Add New Menu Item");
        System.out.println("(3) Remove Menu Item");

        System.out.println("Enter your choice:");
        choice = CustomInput.choice(1, 3);
        System.out.println("");

        switch (choice) {
        case 1:
            displayOption();
            break;
        case 2:
            addNewMenuOption();
            break;
        case 3:
            removeMenuOption();
            break;

        }

    }

    private void displayOption() {
        System.out.println("(1) Display Appetizer");
        System.out.println("(2) Display Main Course");
        System.out.println("(3) Display Dessert");
        System.out.println("(4) Display Drinks");
        System.out.println("(5) Display Promo Packages");

        System.out.println("Enter your choice:");
        choice = CustomInput.choice(1, 5);
        System.out.println("");

        switch (choice) {
        case 1:
            MenuMgr.showAppetizer();
            break;
        case 2:
            MenuMgr.showMainCourse();
            break;
        case 3:
            MenuMgr.showDessert();
            break;
        case 4:
            MenuMgr.showDrinks();
            break;
        case 5:
            MenuMgr.showPackage();

        }

    }

    private void addNewMenuOption() {

        System.out.println("(1) Add new Appetizer");
        System.out.println("(2) Add new Main Course");
        System.out.println("(3) Add new Dessert");
        System.out.println("(4) Add new Drinks");
        System.out.println("(5) Add new Promo Packages");

        choice = CustomInput.choice(1, 5);
        System.out.print("New menu item name: ");
        String menuName = scanner.nextLine();
        System.out.print("Price of the new menu item:");
        double price = CustomInput.nextDouble();
        System.out.println("Description of new menu item:");
        String description = scanner.nextLine();
        System.out.println("New menu item ID:");
        String itemID = scanner.nextLine();
        switch (choice) {
        case 1:
            Appetizer newAppetizer = new Appetizer(menuName, price, description, itemID);
            MenuMgr.addAppe(newAppetizer);
            break;
        case 2:
            MainCourse newMainCourse = new MainCourse(menuName, price, description, itemID);
            MenuMgr.addMainCourse(newMainCourse);
            break;
        case 3:
            Dessert newDessert = new Dessert(menuName, price, description, itemID);
            MenuMgr.addDessert(newDessert);
            break;
        case 4:
            Drinks newDrinks = new Drinks(menuName, price, description, itemID);
            MenuMgr.addDrinks(newDrinks);
            break;
        case 5:

        }
    }

    private void removeMenuOption() {
        String itemID = "";
        System.out.println("(1) Remove an Appetizer");
        System.out.println("(2) Remove a Main Course");
        System.out.println("(3) Remove a Dessert");
        System.out.println("(4) Remove a Drinks");
        System.out.println("(5) Remove a Promo Packages");
        choice = CustomInput.choice(1, 5);

        switch (choice) {
        case 1:
            MenuMgr.showAppetizer();
            System.out.println("Enter the ID of item to be removed:");
            itemID = scanner.nextLine();
            MenuMgr.removeAppetizer(itemID);
        case 2:
            MenuMgr.showMainCourse();
            System.out.println("Enter the ID of item to be removed:");
            itemID = scanner.nextLine();
            MenuMgr.removeMainCourse(itemID);
        case 3:
            MenuMgr.showDessert();
            System.out.println("Enter the ID of item to be removed:");
            itemID = scanner.nextLine();
            MenuMgr.removeDessert(itemID);
        case 4:
            MenuMgr.showDrinks();
            System.out.println("Enter the ID of item to be removed:");
            itemID = scanner.nextLine();
            MenuMgr.removeDrinks(itemID);
        case 5:
            MenuMgr.showPackage();
            System.out.println("Enter the ID of item to be removed:");
            itemID = scanner.nextLine();
            MenuMgr.removePackage(itemID);
        }
    }

}

package boundaryclass;

import java.util.InputMismatchException;
import java.util.Scanner;

import controllerclass.MenuMgr;

public class MenuInterface {
    private Scanner scanner = new Scanner(System.in);
    int choice;

    public void showOption() {
        boolean invalidInput = true;
        while (invalidInput) {
            System.out.println("(1) Display Menu");
            System.out.println("(2) Add New Menu Item");
            System.out.println("(3) Remove Menu Item");

            try {
                System.out.println("Enter your choice:");
                choice = scanner.nextInt();
                invalidInput = false;
                System.out.println("");
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
                scanner.next();
            }
        }

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
        boolean invalidInput = true;
        while (invalidInput) {
            System.out.println("(1) Display Appetizer");
            System.out.println("(2) Display Main Course");
            System.out.println("(3) Display Dessert");
            System.out.println("(4) Display Drinks");
            System.out.println("(5) Display Promo Packages");
            try {
                System.out.println("Enter your choice:");
                choice = scanner.nextInt();
                invalidInput = false;
                System.out.println("");
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
                scanner.next();
            }
        }
        switch (choice) {
        case 1:
            MenuMgr.showAppetizer();

        }

    }

    private void addNewMenuOption() {
        System.out.println("(1) Add new Appetizer");
        System.out.println("(2) Add new Main Course");
        System.out.println("(3) Add new Dessert");
        System.out.println("(4) Add new Drinks");
        System.out.println("(5) Add new Promo Packages");
        choice = scanner.nextInt();
    }

    private void removeMenuOption() {
        System.out.println("(1) Remove an Appetizer");
        System.out.println("(2) Remove a Main Course");
        System.out.println("(3) Remove a Dessert");
        System.out.println("(4) Remove a Drinks");
        System.out.println("(5) Remove a Promo Packages");
        choice = scanner.nextInt();
    }

}

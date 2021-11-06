package boundaryclass;

import java.util.ArrayList;
import java.util.Scanner;

import controllerclass.MenuMgr;
import entityclass.Appetizer;
import entityclass.Dessert;
import entityclass.Drinks;
import entityclass.MainCourse;
import entityclass.MenuItem;
import entityclass.PackageItem;
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
        
        case 4:
            updateMenuOption();
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
            break;

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
            PackageItem newPackage = createPackage(menuName, price, description, itemID);
            MenuMgr.addPackage(newPackage);
            break;
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
            break;
        case 2:
            MenuMgr.showMainCourse();
            System.out.println("Enter the ID of item to be removed:");
            itemID = scanner.nextLine();
            MenuMgr.removeMainCourse(itemID);
            break;
        case 3:
            MenuMgr.showDessert();
            System.out.println("Enter the ID of item to be removed:");
            itemID = scanner.nextLine();
            MenuMgr.removeDessert(itemID);
            break;
        case 4:
            MenuMgr.showDrinks();
            System.out.println("Enter the ID of item to be removed:");
            itemID = scanner.nextLine();
            MenuMgr.removeDrinks(itemID);
            break;
        case 5:
            MenuMgr.showPackage();
            System.out.println("Enter the ID of item to be removed:");
            itemID = scanner.nextLine();
            MenuMgr.removePackage(itemID);
            break;
        }
    }

    private void updateMenuOption() {
        String itemID = "";
        System.out.println("(1) Update an Appetizer");
        System.out.println("(2) Update a Main Course");
        System.out.println("(3) Update a Dessert");
        System.out.println("(4) Update a Drinks");
        System.out.println("(5) Update a Promo Packages");
        choice = CustomInput.choice(1, 5);

        switch (choice) {
        case 1:
            MenuMgr.showAppetizer();
            System.out.println("Enter the ID of item to be updated:");
            itemID = scanner.nextLine();
            System.out.println("Update (1)Name/(2)Price/(3)Description?");
            int appeChoice = CustomInput.choice(1,3);
            switch(appeChoice){
                case 1:
                    System.out.println("Enter the new name of the item: ");
                    String newname = scanner.nextLine();
                    MenuMgr.changeAppetizerName(itemID, newname);
                    break;
                case 2:
                    System.out.println("Enter the new price of the item: ");
                    double newprice = CustomInput.nextPositiveDouble();
                    MenuMgr.changeAppePrice(itemID, newprice);
                    break;
                case 3:
                    System.out.println("Enter the new description of the item: ");
                    String description = scanner.nextLine();
                    MenuMgr.changeAppetizerDescription(itemID, description);
                    break;
            }
            break;
        case 2:
            MenuMgr.showMainCourse();
            System.out.println("Enter the ID of item to be removed:");
            itemID = scanner.nextLine();
            System.out.println("Update (1)Name/(2)Price/(3)Description?");
            int mainCourseChoice = CustomInput.choice(1,3);
            switch(mainCourseChoice){
                case 1:
                    System.out.println("Enter the new name of the item: ");
                    String newname = scanner.nextLine();
                    MenuMgr.changeMainCourseName(itemID, newname);
                    break;
                case 2:
                    System.out.println("Enter the new price of the item: ");
                    double newprice = CustomInput.nextPositiveDouble();
                    MenuMgr.changeMainCoursePrice(itemID, newprice);
                    break;
                case 3:
                    System.out.println("Enter the new description of the item: ");
                    String description = scanner.nextLine();
                    MenuMgr.changeMainCourseDescription(itemID, description);
                    break;
            }
            break;
        case 3:
            MenuMgr.showDessert();
            System.out.println("Enter the ID of item to be removed:");
            itemID = scanner.nextLine();
            System.out.println("Update (1)Name/(2)Price/(3)Description?");
            int DessertChoice = CustomInput.choice(1,3);
            switch(DessertChoice){
                case 1:
                    System.out.println("Enter the new name of the item: ");
                    String newname = scanner.nextLine();
                    MenuMgr.changeDessertName(itemID, newname);
                    break;
                case 2:
                    System.out.println("Enter the new price of the item: ");
                    double newprice = CustomInput.nextPositiveDouble();
                    MenuMgr.changeDessertPrice(itemID, newprice);
                    break;
                case 3:
                    System.out.println("Enter the new description of the item: ");
                    String description = scanner.nextLine();
                    MenuMgr.changeDessertDescription(itemID, description);
                    break;
            }
            break;
        case 4:
            MenuMgr.showDrinks();
            System.out.println("Enter the ID of item to be removed:");
            itemID = scanner.nextLine();
            System.out.println("Update (1)Name/(2)Price/(3)Description?");
            int drinksChoice = CustomInput.choice(1, 3);
            switch(drinksChoice){
                case 1:
                    System.out.println("Enter the new name of the item: ");
                    String newname = scanner.nextLine();
                    MenuMgr.changeDrinksName(itemID, newname);
                    break;
                case 2:
                    System.out.println("Enter the new price of the item: ");
                    double newprice = CustomInput.nextPositiveDouble();
                    MenuMgr.changeDrinksPrice(itemID, newprice);
                    break;
                case 3:
                    System.out.println("Enter the new description of the item: ");
                    String description = scanner.nextLine();
                    MenuMgr.changeDrinksDescription(itemID, description);
                    break;
            }
            break;
        case 5:
            MenuMgr.showPackage();
            System.out.println("Enter the ID of item to be removed:");
            itemID = scanner.nextLine();
            System.out.println("Update (1)Name/(2)Price/(3)Description?");
            int packagesChoice = CustomInput.choice(1, 3);
            switch(packagesChoice){
                case 1:
                    System.out.println("Enter the new name of the item: ");
                    String newname = scanner.nextLine();
                    MenuMgr.changePackagesName(itemID, newname);
                    break;
                case 2:
                    System.out.println("Enter the new price of the item: ");
                    double newprice = CustomInput.nextPositiveDouble();
                    MenuMgr.changePackagesPrice(itemID, newprice);
                    break;
                case 3:
                    System.out.println("Enter the new description of the item: ");
                    String description = scanner.nextLine();
                    MenuMgr.changePackagesDescription(itemID, description);
                    break;
            }
            break;
        }
    }

    private PackageItem createPackage(String name,double price,String description, String id){
        Drinks packageDrinks = null;
        MainCourse packageMainCourse = null;
        Dessert packageDessert = null;
        System.out.println("Enter the drinks ID: ");
        String drinksID = scanner.nextLine();
        boolean drinksExist = false;
        while(!drinksExist){
            try{
                packageDrinks = MenuMgr.findDrinksbyID(drinksID);
                drinksExist = true;
            }catch (IndexOutOfBoundsException e){
                System.out.println("Drinks not found! ");
                System.out.println("Enter Drinks ID again");
            }
        }
        System.out.println("Enter the Main Course ID: ");
        String maincourseID = scanner.nextLine();
        boolean maincourseExist = false;
        while(!maincourseExist){
            try{
                packageMainCourse = MenuMgr.findMainCoursebyID(maincourseID);
                maincourseExist = true;
            }catch (IndexOutOfBoundsException e){
                System.out.println("Main Course not found! ");
                System.out.println("Enter Main Course ID again: ");
            }
        }
        System.out.println("Enter the Dessert ID: ");
        String dessertID = scanner.nextLine();
        boolean dessertExist = false;
        while(!dessertExist){
            try{
                packageDessert = MenuMgr.findDessertbyID(dessertID);
                dessertExist = true;
            }catch (IndexOutOfBoundsException e){
                System.out.println("Dessert not found! ");
                System.out.println("Enter Dessert ID again");
            }
        }
        ArrayList<MenuItem> itemsinPackage = new ArrayList<MenuItem>();
        itemsinPackage.add(packageDrinks);
        itemsinPackage.add(packageMainCourse);
        itemsinPackage.add(packageDessert);

        PackageItem newPackage = new PackageItem(name, price, description, itemsinPackage, id);
        return newPackage;

    }

}

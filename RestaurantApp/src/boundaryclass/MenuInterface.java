package boundaryclass;

import java.util.ArrayList;
import java.util.Scanner;

import controllerclass.MenuMgr;
import entityclass.MenuItem;
import entityclass.PackageItem;
import entityclass.MenuItem.ItemType;
import utils.CustomInput;

public class MenuInterface {
    private static Scanner scanner = new Scanner(System.in);
    private static int choice;

    /**
     * Function to show all front-end options available for user to choose for them
     * to edit Menu (1)Display a menu of their choice (2)Add an item to a list of
     * their choice (3)Remove an item from a list of their choice (4)Update an item
     * from a list of their choice (0)Exit the program
     * 
     * @see MenuMgr
     */
    public static void showOption() {
        boolean on = true;

        while (on) {

            System.out.println("(1) Display Menu");
            System.out.println("(2) Add New Menu Item");
            System.out.println("(3) Remove Menu Item");
            System.out.println("(4) Update Menu Item");
            System.out.println("(0) exit");

            choice = CustomInput.choice(0, 4);
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
            case 0:
                on = false;
            }
        }

    }

    /**
     * Function for user to choose which list to display Call corresponding show
     * functions from MenuMgr Input result: (1) Display Appetizer list (2) Display
     * Main Course List (3) Display Dessert List (4) Display Drinks List (5) Display
     * Promo Pacakge List (0) Go back to the previous menu
     * 
     * @see MenuMgr
     */
    private static void displayOption() {
        boolean on = true;
        while (on) {
            System.out.println("(1) Display Appetizer");
            System.out.println("(2) Display Main Course");
            System.out.println("(3) Display Dessert");
            System.out.println("(4) Display Drinks");
            System.out.println("(5) Display Promo Packages");
            System.out.println("(6) Display The Complete Menu");
            System.out.println("(0) Go back");

            choice = CustomInput.choice(0, 6);
            System.out.println("");

            switch (choice) {
            case 1:
                MenuMgr.showItemList(ItemType.APPETIZER);
                break;
            case 2:
                MenuMgr.showItemList(ItemType.MAINCOURSE);
                break;
            case 3:
                MenuMgr.showItemList(ItemType.DESSERT);
                break;
            case 4:
                MenuMgr.showItemList(ItemType.DRINKS);
                break;
            case 5:
                MenuMgr.showPackage();
                break;
            case 6:
                MenuMgr.showMenu();
                break;
            case 0:
                on = false;
            }
        }

    }

    /**
     * Function to add new MenuItem into a list of users choice Call corresponding
     * function from MenuMgr Input corresponds to: (1)Add a new item to Appetizer
     * list (2)Add a new item to Main Course list (3)Add a new item to Dessert list
     * (4)Add a new item to Drinks List (5)Add a new item to PackageItem list (0)Go
     * back to the previous menu
     * 
     * @see MenuMgr
     */
    private static void addNewMenuOption() {
        boolean on = true;

        while (on) {
            System.out.println("(1) Add new Appetizer");
            System.out.println("(2) Add new Main Course");
            System.out.println("(3) Add new Dessert");
            System.out.println("(4) Add new Drinks");
            System.out.println("(5) Add new Promo Packages");
            System.out.println("(0) Go back");

            choice = CustomInput.choice(0, 5);
            if (choice == 0)
                break;
            System.out.print("New menu item name: ");
            String menuName = scanner.nextLine();
            System.out.println("Price of the new menu item");
            double price = CustomInput.nextPositiveDouble();
            System.out.println("Description of new menu item:");
            String description = scanner.nextLine();
            System.out.println("New menu item ID:");
            String itemID = scanner.nextLine();
            switch (choice) {
            case 1:
                try {
                    boolean itemexist = true;
                    while (itemexist) {
                        MenuItem oldAppetizer = MenuMgr.findItembyID(itemID);
                        System.out.printf("This ID, %s, belongs to item, %s\n", itemID, oldAppetizer.getItemName());
                        System.out.println("Enter a new unique ID: ");
                        itemID = scanner.nextLine();
                    }
                } catch (IndexOutOfBoundsException e) {
                    boolean validID = false;
                    while (!validID) {
                        if (itemID.charAt(0) == 'A') {
                            validID = true;
                        }
                        System.out.println("Please enter a valid item ID: ");
                        itemID = scanner.nextLine();
                    }
                    MenuItem newAppetizer = new MenuItem(menuName, price, description, itemID, ItemType.APPETIZER);
                    MenuMgr.addMenuItem(newAppetizer);
                }
                break;
            case 2:
                try {
                    boolean itemexist = true;
                    while (itemexist) {
                        MenuItem oldMainCourse = MenuMgr.findItembyID(itemID);
                        System.out.printf("This ID, %s, belongs to item, %s\n", itemID, oldMainCourse.getItemName());
                        System.out.println("Enter a new unique ID: ");
                        itemID = scanner.nextLine();
                    }
                } catch (IndexOutOfBoundsException e) {
                    boolean validID = false;
                    while (!validID) {
                        if (itemID.charAt(0) == 'A') {
                            validID = true;
                            itemID = scanner.nextLine();
                        }
                        System.out.println("Please enter a valid item ID: ");
                    }
                    MenuItem newMainCourse = new MenuItem(menuName, price, description, itemID, ItemType.MAINCOURSE);
                    MenuMgr.addMenuItem(newMainCourse);
                }
                break;
            case 3:
                try {
                    boolean itemexist = true;
                    while (itemexist) {
                        MenuItem oldDessert = MenuMgr.findItembyID(itemID);
                        System.out.printf("This ID, %s, belongs to item, %s\n", itemID, oldDessert.getItemName());
                        System.out.println("Enter a new unique ID: ");
                        itemID = scanner.nextLine();
                    }
                } catch (IndexOutOfBoundsException e) {
                    boolean validID = false;
                    while (!validID) {
                        if (itemID.charAt(0) == 'A') {
                            validID = true;
                        }
                        System.out.println("Please enter a valid item ID: ");
                        itemID = scanner.nextLine();
                    }
                    MenuItem newDessert = new MenuItem(menuName, price, description, itemID, ItemType.DESSERT);
                    MenuMgr.addMenuItem(newDessert);
                }
                break;
            case 4:
                try {
                    boolean itemexist = true;
                    while (itemexist) {
                        MenuItem oldDrinks = MenuMgr.findItembyID(itemID);
                        System.out.printf("This ID, %s, belongs to item, %s\n", itemID, oldDrinks.getItemName());
                        System.out.println("Enter a new unique ID: ");
                        itemID = scanner.nextLine();
                    }
                } catch (IndexOutOfBoundsException e) {
                    boolean validID = false;
                    while (!validID) {
                        if (itemID.charAt(0) == 'A') {
                            validID = true;
                        }
                        System.out.println("Please enter a valid item ID: ");
                        itemID = scanner.nextLine();
                    }
                    MenuItem newDrinks = new MenuItem(menuName, price, description, itemID, ItemType.DRINKS);
                    MenuMgr.addMenuItem(newDrinks);
                }
                break;
            case 5:
                try {
                    boolean itemexist = true;
                    while (itemexist) {
                        PackageItem oldPackage = MenuMgr.findPackagebyID(itemID);
                        System.out.printf("This ID, %s, belongs to item, %s\n", itemID, oldPackage.getItemName());
                        System.out.println("Enter a new unique ID: ");
                        itemID = scanner.nextLine();
                    }
                } catch (IndexOutOfBoundsException e) {
                    boolean validID = false;
                    while (!validID) {
                        if (itemID.charAt(0) == 'A') {
                            validID = true;
                        }
                        System.out.println("Please enter a valid item ID: ");
                        itemID = scanner.nextLine();
                    }
                    PackageItem newPackage = createPackage(menuName, price, description, itemID);
                    MenuMgr.addPackage(newPackage);
                }
                break;
            case 0:
                on = false;
                break;
            }
        }
    }

    /**
     * Function to remove an existing MenuItem from a list of user's choice Call
     * corresponding function from MenuMgr Input corresponds to (1)Remove an item
     * from Appetizer list (2)Remove an item from Main Course list (3)Remove an item
     * from Dessert list (4)Remove an item from PackageItem list (0)Go back to the
     * previous menu
     * 
     * @see MenuMgr
     */
    private static void removeMenuOption() {
        Boolean on = true;
        String itemID = "";

        while (on) {
            System.out.println("(1) Remove an Appetizer");
            System.out.println("(2) Remove a Main Course");
            System.out.println("(3) Remove a Dessert");
            System.out.println("(4) Remove a Drinks");
            System.out.println("(5) Remove a Promo Packages");
            System.out.println("(0) Go back\n");
            choice = CustomInput.choice(0, 5);

            switch (choice) {
            case 1:
                MenuMgr.showItemList(ItemType.APPETIZER);
                System.out.println("Enter the ID of item to be removed:");
                itemID = scanner.nextLine();
                MenuMgr.removeMenuItem(itemID);
                break;
            case 2:
                MenuMgr.showItemList(ItemType.MAINCOURSE);
                System.out.println("Enter the ID of item to be removed:");
                itemID = scanner.nextLine();
                MenuMgr.removeMenuItem(itemID);
                break;
            case 3:
                MenuMgr.showItemList(ItemType.DESSERT);
                System.out.println("Enter the ID of item to be removed:");
                itemID = scanner.nextLine();
                MenuMgr.removeMenuItem(itemID);
                break;
            case 4:
                MenuMgr.showItemList(ItemType.DRINKS);
                System.out.println("Enter the ID of item to be removed:");
                itemID = scanner.nextLine();
                MenuMgr.removeMenuItem(itemID);
                break;
            case 5:
                MenuMgr.showPackage();
                System.out.println("Enter the ID of item to be removed:");
                itemID = scanner.nextLine();
                MenuMgr.removePackage(itemID);
                break;
            case 0:
                on = false;
            }
        }
    }

    /**
     * Function for user to update a MenuItem from the list of their choice Call
     * corresponding function from MenuMgr Index corresponds to (1)Update an item in
     * Appetizer List (2)Update an item in Main Course list (3)Update an item in
     * Dessert List (4)Update an item in Drinks list (5)Update an item in
     * PackageItem list (0)Go back to the previous menu After a valid input is made,
     * user will have to choose with item they want to change by ID and will be
     * prompted to make another input on which attributes of the MenuItem do they
     * want to change Choice includes: (1)Change Name of the corresponding MenuItem
     * (2)Change Price of the corresponding MenuItem (3)Change Description of the
     * corresponding MenuItem
     * 
     * @see MenuMgr
     */

    private static void updateMenuOption() {
        Boolean on = true;
        String itemID = "";

        while (on) {
            System.out.println("(1) Update an Appetizer");
            System.out.println("(2) Update a Main Course");
            System.out.println("(3) Update a Dessert");
            System.out.println("(4) Update a Drinks");
            System.out.println("(5) Update a Promo Packages");
            System.out.println("(0) Go back");
            choice = CustomInput.choice(0, 5);

            switch (choice) {
            case 1:
                MenuMgr.showItemList(ItemType.APPETIZER);
                System.out.println("Enter the ID of item to be updated:");
                itemID = scanner.nextLine();
                boolean appeExist = false;
                while (!appeExist) {
                    try {
                        MenuItem changingAppetizer = MenuMgr.findItembyID(itemID);
                        System.out.println("Name of appetizer: " + changingAppetizer.getItemName());
                        System.out.println("Price of appetizer: " + changingAppetizer.getPrice());
                        System.out.println("Description of appetizer" + changingAppetizer.getDescription());
                        appeExist = true;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Item not found!");
                        System.out.println("Enter item ID again: ");
                        itemID = scanner.nextLine();
                    }
                }
                System.out.println("Update");
                System.out.println("(1)Name");
                System.err.println("(2)Price");
                System.out.println("(3)Description");
                System.out.println("(0) Go back");
                int appeChoice = CustomInput.choice(0, 3);
                switch (appeChoice) {
                case 1:
                    System.out.println("Enter the new name of the item: ");
                    String newname = scanner.nextLine();
                    MenuMgr.changeMenuItemName(itemID, newname);
                    break;
                case 2:
                    System.out.println("Enter the new price of the item: ");
                    double newprice = CustomInput.nextPositiveDouble();
                    MenuMgr.changeMenuItemPrice(itemID, newprice);
                    break;
                case 3:
                    System.out.println("Enter the new description of the item: ");
                    String description = scanner.nextLine();
                    MenuMgr.changeMenuItemDescription(itemID, description);
                    break;
                }
                break;
            case 2:
                MenuMgr.showItemList(ItemType.MAINCOURSE);
                System.out.println("Enter the ID of item to be removed:");
                itemID = scanner.nextLine();
                boolean mainCourseExist = false;
                while (!mainCourseExist) {
                    try {
                        MenuItem changingMainCourse = MenuMgr.findItembyID(itemID);
                        System.out.println("Name of Main Course: " + changingMainCourse.getItemName());
                        System.out.println("Price of Main Course: " + changingMainCourse.getPrice());
                        System.out.println("Description of Main Course" + changingMainCourse.getDescription());
                        mainCourseExist = true;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Item not found!");
                        System.out.println("Enter item ID again: ");
                        itemID = scanner.nextLine();
                    }
                }
                System.out.println("Update");
                System.out.println("(1)Name");
                System.err.println("(2)Price");
                System.out.println("(3)Description");
                System.out.println("(0) Go back");
                int mainCourseChoice = CustomInput.choice(0, 3);
                switch (mainCourseChoice) {
                case 1:
                    System.out.println("Enter the new name of the item: ");
                    String newname = scanner.nextLine();
                    MenuMgr.changeMenuItemName(itemID, newname);
                    break;
                case 2:
                    System.out.println("Enter the new price of the item: ");
                    double newprice = CustomInput.nextPositiveDouble();
                    MenuMgr.changeMenuItemPrice(itemID, newprice);
                    break;
                case 3:
                    System.out.println("Enter the new description of the item: ");
                    String description = scanner.nextLine();
                    MenuMgr.changeMenuItemDescription(itemID, description);
                    break;
                }
                break;
            case 3:
                MenuMgr.showItemList(ItemType.DESSERT);
                System.out.println("Enter the ID of item to be removed:");
                itemID = scanner.nextLine();
                boolean dessertExist = false;
                while (!dessertExist) {
                    try {
                        MenuItem changingDessert = MenuMgr.findItembyID(itemID);
                        System.out.println("Name of Dessert: " + changingDessert.getItemName());
                        System.out.println("Price of Dessert: " + changingDessert.getPrice());
                        System.out.println("Description of Dessert" + changingDessert.getDescription());
                        dessertExist = true;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Item not found!");
                        System.out.println("Enter item ID again: ");
                        itemID = scanner.nextLine();
                    }
                }
                System.out.println("Update");
                System.out.println("(1)Name");
                System.err.println("(2)Price");
                System.out.println("(3)Description");
                System.out.println("(0) Go back");
                int DessertChoice = CustomInput.choice(0, 3);
                switch (DessertChoice) {
                case 1:
                    System.out.println("Enter the new name of the item: ");
                    String newname = scanner.nextLine();
                    MenuMgr.changeMenuItemName(itemID, newname);
                    break;
                case 2:
                    System.out.println("Enter the new price of the item: ");
                    double newprice = CustomInput.nextPositiveDouble();
                    MenuMgr.changeMenuItemPrice(itemID, newprice);
                    break;
                case 3:
                    System.out.println("Enter the new description of the item: ");
                    String description = scanner.nextLine();
                    MenuMgr.changeMenuItemDescription(itemID, description);
                    break;
                }
                break;
            case 4:
                MenuMgr.showItemList(ItemType.DRINKS);
                System.out.println("Enter the ID of item to be removed:");
                itemID = scanner.nextLine();
                boolean drinksExist = false;
                while (!drinksExist) {
                    try {
                        MenuItem changingDrinks = MenuMgr.findItembyID(itemID);
                        System.out.println("Name of Drinks: " + changingDrinks.getItemName());
                        System.out.println("Price of Drinks: " + changingDrinks.getPrice());
                        System.out.println("Description of Drinks: " + changingDrinks.getDescription());
                        drinksExist = true;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Item not found!");
                        System.out.println("Enter item ID again: ");
                        itemID = scanner.nextLine();
                    }
                }
                System.out.println("Update");
                System.out.println("(1)Name");
                System.err.println("(2)Price");
                System.out.println("(3)Description");
                System.out.println("(0) Go back");
                int drinksChoice = CustomInput.choice(0, 3);
                switch (drinksChoice) {
                case 1:
                    System.out.println("Enter the new name of the item: ");
                    String newname = scanner.nextLine();
                    MenuMgr.changeMenuItemName(itemID, newname);
                    break;
                case 2:
                    System.out.println("Enter the new price of the item: ");
                    double newprice = CustomInput.nextPositiveDouble();
                    MenuMgr.changeMenuItemPrice(itemID, newprice);
                    break;
                case 3:
                    System.out.println("Enter the new description of the item: ");
                    String description = scanner.nextLine();
                    MenuMgr.changeMenuItemDescription(itemID, description);
                    break;
                }
                break;
            case 5:
                MenuMgr.showPackage();
                System.out.println("Enter the ID of item to be updated:");
                itemID = scanner.nextLine();
                boolean packageExist = false;
                while (!packageExist) {
                    try {
                        PackageItem changingDrinks = MenuMgr.findPackagebyID(itemID);
                        System.out.println("Name of Package: " + changingDrinks.getItemName());
                        System.out.println("Price of Package: " + changingDrinks.getPrice());
                        System.out.println("Description of Package: " + changingDrinks.getDescription());
                        packageExist = true;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Item not found!");
                        System.out.println("Enter item ID again: ");
                        itemID = scanner.nextLine();
                    }
                }
                System.out.println("Update");
                System.out.println("(1)Name");
                System.out.println("(2)Price");
                System.out.println("(3)Description");
                System.out.println("(4)Items in Package");
                System.out.println("(0) Go back");
                int packagesChoice = CustomInput.choice(0, 4);
                switch (packagesChoice) {

                case 1:
                    System.out.println("Enter the new name of the item: \n");
                    String newname = scanner.nextLine();
                    MenuMgr.changePackagesName(itemID, newname);
                    break;
                case 2:
                    System.out.println("Enter the new price of the item: \n");
                    double newprice = CustomInput.nextPositiveDouble();
                    MenuMgr.changePackagesPrice(itemID, newprice);
                    break;
                case 3:
                    System.out.println("Enter the new description of the item: \n");
                    String description = scanner.nextLine();
                    MenuMgr.changePackagesDescription(itemID, description);
                    break;
                case 4:
                    while (true) {
                        try {
                            System.out.println("Enter id of item to be changed: ");
                            System.out.println();
                            String foodID = scanner.nextLine();
                            MenuMgr.removeiteminPackage(itemID, foodID);
                            System.out.println("Enter id of item to be added into this package: ");
                            System.out.println();
                            String newfoodID = scanner.nextLine();
                            MenuMgr.addintoPackage(itemID, newfoodID);
                            System.out.println("Item added");
                            System.out.println();
                            break;
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Invalid input! Try again");
                            continue;
                        }
                    }
                }
            case 0:
                on = false;
            }
        }

    }

    /**
     * Seperate function to create new PackageItem as PromoPackages includes a list
     * of MenuItem
     * 
     * @param name
     * @param price
     * @param description
     * @param id
     * @return new PackageItem created
     * @see PackageItem
     */
    private static PackageItem createPackage(String name, double price, String description, String id) {
        MenuItem packageDrinks = null;
        MenuItem packageMainCourse = null;
        MenuItem packageDessert = null;
        System.out.println("Enter the drinks ID: ");
        String drinksID = scanner.nextLine();
        boolean drinksExist = false;
        while (!drinksExist) {
            try {
                packageDrinks = MenuMgr.findItembyID(drinksID);
                drinksExist = true;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Drinks not found! ");
                System.out.println("Enter Drinks ID again");
                drinksID = scanner.nextLine();
            }
        }
        System.out.println("Enter the Main Course ID: ");
        String maincourseID = scanner.nextLine();
        boolean maincourseExist = false;
        while (!maincourseExist) {
            try {
                packageMainCourse = MenuMgr.findItembyID(maincourseID);
                maincourseExist = true;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Main Course not found! ");
                System.out.println("Enter Main Course ID again: ");
                maincourseID = scanner.nextLine();
            }
        }
        System.out.println("Enter the Dessert ID: ");
        String dessertID = scanner.nextLine();
        boolean dessertExist = false;
        while (!dessertExist) {
            try {
                packageDessert = MenuMgr.findItembyID(dessertID);
                dessertExist = true;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Dessert not found! ");
                System.out.println("Enter Dessert ID again");
                dessertID = scanner.nextLine();
            }
        }
        ArrayList<MenuItem> itemsinPackage = new ArrayList<MenuItem>();
        itemsinPackage.add(packageDrinks);
        itemsinPackage.add(packageMainCourse);
        itemsinPackage.add(packageDessert);

        PackageItem newPackage = new PackageItem(name, price, description, itemsinPackage, id, ItemType.PACKAGE);
        return newPackage;

    }

}

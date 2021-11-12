package controllerclass;

import java.util.ArrayList;

import database.Restaurant;
import entityclass.*;

public class MenuMgr {
    private static Menu restaurantMenu = Restaurant.restaurantMenu;

    /**
     * Function to print Appetizer list
     */
    public static void showAppetizer() {
        ArrayList<Appetizer> appeList = restaurantMenu.getAppeList();
        System.out.println("          APPETIZER          ");
        System.out.println("******************************\n");
        if (appeList.size() == 0) {
            System.out.println("This list is empty");
        }
        for (int i = 0; i < appeList.size(); i++) {
            Appetizer item = appeList.get(i);
            System.out.println("Name: " + item.getItemName());
            System.out.println("Price: " + item.getPrice());
            System.out.println("Description: " + item.getDescription());
            System.out.println("ID: " + item.getItemID());
            System.out.println("******************************\n");

        }
    }

    /**
     * Function to print MainCourse List
     */
    public static void showMainCourse() {
        ArrayList<MainCourse> mainCourseList = restaurantMenu.getMainCourseList();
        System.out.println("          MAIN COURSE          ");
        System.out.println("******************************");
        if (mainCourseList.size() == 0) {
            System.out.println("This list is empty");
        }
        for (int i = 0; i < mainCourseList.size(); i++) {
            MainCourse item = mainCourseList.get(i);
            System.out.println("Name: " + item.getItemName());
            System.out.println("Price: " + item.getPrice());
            System.out.println("Description: " + item.getDescription());
            System.out.println("ID: " + item.getItemID());
            System.out.println("******************************\n");

        }

    }

    /**
     * Function to print Dessert List
     */
    public static void showDessert() {
        ArrayList<Dessert> dessertList = restaurantMenu.getDessertList();
        System.out.println("          DESSERT          ");
        System.out.println("******************************");
        if (dessertList.size() == 0) {
            System.out.println("This list is empty");
        }
        for (int i = 0; i < dessertList.size(); i++) {
            Dessert item = dessertList.get(i);
            System.out.println("Name: " + item.getItemName());
            System.out.println("Price: " + item.getPrice());
            System.out.println("Description: " + item.getDescription());
            System.out.println("ID: " + item.getItemID());
            System.out.println("******************************\n");

        }
    }

    /**
     * Function to print Drinks List
     */
    public static void showDrinks() {
        ArrayList<Drinks> drinksList = restaurantMenu.getDrinksList();
        System.out.println("          DRINKS         ");
        System.out.println("******************************");
        if (drinksList.size() == 0) {
            System.out.println("This list is empty");
        }
        for (int i = 0; i < drinksList.size(); i++) {
            Drinks item = drinksList.get(i);
            System.out.println("Name: " + item.getItemName());
            System.out.println("Price: " + item.getPrice());
            System.out.println("Description: " + item.getDescription());
            System.out.println("ID: " + item.getItemID());
            System.out.println("******************************\n");

        }
    }

    /**
     * Function to print PackageList
     */
    public static void showPackage() {
        ArrayList<PackageItem> packagesList = restaurantMenu.getPackagesList();
        System.out.println("          SPECIAL PACKAGES         ");
        System.out.println("******************************");
        if (packagesList.size() == 0) {
            System.out.println("This list is empty");
        }
        for (int i = 0; i < packagesList.size(); i++) {
            PackageItem item = packagesList.get(i);
            ArrayList<MenuItem> packageList = item.getpackageList();
            System.out.println("Name: " + item.getItemName());
            System.out.println("Price: " + item.getPrice());
            System.out.println("Description: " + item.getDescription());
            System.out.println("Items included are ");
            for (int j = 0; j < packageList.size(); j++) {
                MenuItem iteminpackage = packageList.get(j);
                System.out.printf("(%d) %s \n", j + 1, iteminpackage.getItemName());
            }
            System.out.println("ID: " + item.getItemID());
            System.out.println("******************************\n");

        }
    }

    /**
     * Function to print Menu(Compilation of all list)
     */

    public static void showMenu() {
        ArrayList<MenuItem> menuList = restaurantMenu.getMenuList();
        System.out.println("          MENU          ");
        System.out.println("******************************");
        if (menuList.size() == 0) {
            System.out.println("This list is empty");
        }
        for (int i = 0; i < menuList.size(); i++) {
            MenuItem item = menuList.get(i);
            System.out.println("Name: " + item.getItemName());
            System.out.println("Price: " + item.getPrice());
            System.out.println("Description: " + item.getDescription());
            if (item instanceof PackageItem) {
                System.out.println("Items included are");
                PackageItem itemtopackage = (PackageItem) item;
                ArrayList<MenuItem> packageList = itemtopackage.getpackageList();
                for (int j = 0; j < packageList.size(); j++) {
                    MenuItem iteminpackage = packageList.get(i);
                    System.out.printf("%d) %s", j + 1, iteminpackage.getItemName());
                }
            }
            System.out.println("ID: " + item.getItemID());
            System.out.println("******************************\n");

        }
    }

    // Functions to edit menu
    // 1) Adding into menu
    // Appetizer
    /**
     * Function to add a new Appetizer to existing list of Appetizer
     * 
     * @param appe (Appetizer)new Appetizer to be added
     * @see Menu
     */
    public static void addAppe(Appetizer appe) {
        restaurantMenu.addintoAppeList(appe);
        restaurantMenu.addintoMenuList(appe);
        System.out.println("Updated Appetizers:");
        showAppetizer();
    }

    // Main Course
    /**
     * Function to add a new MainCourse to existing list of MainCourse
     * 
     * @param maincourse (MainCourse)new MainCourse to be added
     * @see Menu
     */
    public static void addMainCourse(MainCourse maincourse) {
        restaurantMenu.addintoMainCourseList(maincourse);
        restaurantMenu.addintoMenuList(maincourse);
        System.out.println("Updated Main Courses:");
        showMainCourse();
    }

    // Dessert
    /**
     * Function to add a new Dessert to existing list of Dessert
     * 
     * @param dessert (Dessert)new Dessert to be added
     * @see Menu
     */
    public static void addDessert(Dessert dessert) {
        restaurantMenu.addintoDessertList(dessert);
        restaurantMenu.addintoMenuList(dessert);
        System.out.println("Updated Desserts:");
        showDessert();
    }

    // Drinks
    /**
     * Function to add a new Drinks to existing list of Drinks
     * 
     * @param drinks (Drinks)new Drinks item to be added
     * @see Menu
     */
    public static void addDrinks(Drinks drinks) {
        restaurantMenu.addintoDrinksList(drinks);
        restaurantMenu.addintoMenuList(drinks);
        System.out.println("Updated Drinks:");
        showDrinks();
    }

    // Package
    /**
     * Function to add a new PromoPackage to existing list of Packages
     * 
     * @param packages (PackageItem)new PackageItem to be added
     * @see Menu
     */
    public static void addPackage(PackageItem packages) {

        restaurantMenu.addintoPackageList(packages);
        restaurantMenu.addintoMenuList(packages);
        System.out.println("Updated Packages:");
        showPackage();
    }

    // 2) Delete item
    // Appetizer
    /**
     * Function to delete an Appetizer from existing list based on ID Print "Item
     * not found" if ID doesnt exist
     * 
     * @param id (String)ID of Appetizer to be deleted
     * @see Menu
     */
    public static void removeAppetizer(String id) {
        if (restaurantMenu.removeforAppeList(id) == -1) {
            System.out.println("Item not found\n");
        } else {
            restaurantMenu.removeforMenuList(id);
        }
    }

    // MainCourse
    /**
     * Function to delete a MainCourse from existing list based on ID Print "Item
     * not found" if ID doesnt exist
     * 
     * @param id (String)ID of MainCourse to be deleted
     * @see Menu
     */
    public static void removeMainCourse(String id) {
        if (restaurantMenu.removeforMainCourseList(id) == -1) {
            System.out.println("Item not found");
        } else {
            restaurantMenu.removeforMenuList(id);
        }
    }

    // Dessert
    /**
     * Function to delete a Dessert from existing list based on ID Print "Item not
     * found" if ID doesnt exist
     * 
     * @param id (String)ID of Dessert to be deleted
     * @see Menu
     */
    public static void removeDessert(String id) {
        if (restaurantMenu.removeforDessertList(id) == -1) {
            System.out.println("Item not found");
        } else {
            restaurantMenu.removeforMenuList(id);
        }
    }

    // Drinks
    /**
     * Function to delete a Drinks from existing list based on ID Print "Item not
     * found" if ID doesnt exist
     * 
     * @param id (String)ID of Drinks to be deleted
     * @see Menu
     */
    public static void removeDrinks(String id) {
        if (restaurantMenu.removeforDrinksList(id) == -1) {
            System.out.println("Item not found");
        } else {
            restaurantMenu.removeforMenuList(id);
        }
    }

    // Packages
    /**
     * Function to delete a PackageItem from existing list based on ID Print "Item
     * not found" if ID doesnt exist
     * 
     * @param id (String)ID of PackageItem to be deleted
     * @see Menu
     */
    public static void removePackage(String id) {
        if (restaurantMenu.removeforPackageList(id) == -1) {
            System.out.println("Item not found");
        } else {
            restaurantMenu.removeforMenuList(id);
        }
    }

    // Find items
    // 1 - Appetizer
    /**
     * Function to find and return an Appetizer using ID from existing list return
     * IndexOutOfBounds exception if ID not found
     * 
     * @param id (String)ID of Appetizer to be found
     * @return (Appetizer)Corresponding Appetizer based on id
     * @see Menu
     */
    public static Appetizer findAppetizerbyID(String id) {
        int i = restaurantMenu.findforAppeList(id);
        return restaurantMenu.getAppeList().get(i);
    }

    // 2 - Main Course
    /**
     * Function to find and return a MainCourse using ID from existing list return
     * IndexOutOfBounds exception if ID not found
     * 
     * @param id (String)ID of MainCourse to be found
     * @return (MainCourse)Corresponding MainCourse based on id
     * @see Menu
     */
    public static MainCourse findMainCoursebyID(String id) {
        int i = restaurantMenu.findforMainCourseList(id);
        return restaurantMenu.getMainCourseList().get(i);
    }

    // 3 - Drinks
    /**
     * Function to find and return a Drinks using ID from existing list return
     * IndexOutOfBounds exception if ID not found
     * 
     * @param id (String)ID of Drinks to be found
     * @return (Drinks)Corresponding Drinks based on id
     * @see Menu
     */
    public static Drinks findDrinksbyID(String id) {
        int i = restaurantMenu.findforDrinksList(id);
        return restaurantMenu.getDrinksList().get(i);
    }

    // 4 - Dessert
    /**
     * Function to find and return a Dessert using ID from existing list return
     * IndexOutOfBounds exception if ID not found
     * 
     * @param id (String)ID of Dessert to be found
     * @return (Dessert)Corresponding Dessert based on ID
     * @see Menu
     */
    public static Dessert findDessertbyID(String id) {
        int i = restaurantMenu.findforDessertList(id);
        return restaurantMenu.getDessertList().get(i);
    }

    /**
     * Function to find and return a PackageItem using ID from existing list return
     * IndexOutOfBounds exception if ID not found
     * 
     * @param id (String)ID of PackageItem to be found
     * @return (PackageItem)Corresponding PackageItem based on ID
     * @see Menu
     */
    public static PackageItem findPackagebyID(String id) {
        int i = restaurantMenu.findforPackageList(id);
        return restaurantMenu.getPackagesList().get(i);
    }

    // Update Items
    // 1)Change Name
    // (i) main course
    /**
     * Function to change name of a MainCourse item from existing MainCourse list
     * Find MainCourse first, then change name Yield IndexOutOfBounds exception if
     * item not found
     * 
     * @param id      (String)ID of MainCourse item to be updated
     * @param newname (String)New Name of corresponding MainCourse
     */
    public static void changeMainCourseName(String id, String newname) {
        int i = restaurantMenu.findforMainCourseList(id);
        int j = restaurantMenu.findforMenuList(id);
        MainCourse newfood = restaurantMenu.getMainCourseList().get(i);
        newfood.setItemName(newname);
        restaurantMenu.setforMainCourseList(i, newfood);
        restaurantMenu.setforMenuList(j, newfood);
    }

    // (ii) appetizer
    /**
     * Function to change name of an Appetizer item from existing Appetizer list
     * Find Appetizer first,then change name Yield IndexOutOfBounds exception if
     * item not found
     * 
     * @param id      (String)ID of Appetizer item to be updated
     * @param newname (String)New Name of corresponding Appetizer
     */
    public static void changeAppetizerName(String id, String newname) {
        int i = restaurantMenu.findforAppeList(id);
        int j = restaurantMenu.findforMenuList(id);
        Appetizer newfood = restaurantMenu.getAppeList().get(i);
        newfood.setItemName(newname);
        restaurantMenu.setforAppeList(i, newfood);
        restaurantMenu.setforMenuList(j, newfood);
    }

    // (iii)drinks
    /**
     * Function to change name of a Drinks item from existing Drinks list Find
     * Drinks first,then change name Yield IndexOutOfBounds exception if item not
     * found
     * 
     * @param id      (String) ID of Drinks item to be updated
     * @param newname (String)New Name of corresponding Drinks
     */
    public static void changeDrinksName(String id, String newname) {
        int i = restaurantMenu.findforDrinksList(id);
        int j = restaurantMenu.findforMenuList(id);
        Drinks newfood = restaurantMenu.getDrinksList().get(i);
        newfood.setItemName(newname);
        restaurantMenu.setforDrinksList(i, newfood);
        restaurantMenu.setforMenuList(j, newfood);
    }

    // (iv)dessert
    /**
     * Function to change name of a Dessert item from existing Dessert list Find
     * Dessert first,then change name Yield IndexOutOfBounds exception if item not
     * found
     * 
     * @param id      (String) ID of Dessert item to be updated
     * @param newname (String)New Name of corresponding Dessert
     */
    public static void changeDessertName(String id, String newname) {
        int i = restaurantMenu.findforDessertList(id);
        int j = restaurantMenu.findforMenuList(id);
        Dessert newfood = restaurantMenu.getDessertList().get(i);
        newfood.setItemName(newname);
        restaurantMenu.setforDessertList(i, newfood);
        restaurantMenu.setforMenuList(j, newfood);
    }

    // (v)packages
    /**
     * Function to change name of a PackageItem from existing PackageItem list Find
     * PackageItem first,then change name Yield IndexOutOfBounds exception if item
     * not found
     * 
     * @param id      (String) ID of PackageItem to be updated
     * @param newname (String) New Name of corresponding PackageItem
     */
    public static void changePackagesName(String id, String newname) {
        int i = restaurantMenu.findforPackageList(id);
        int j = restaurantMenu.findforMenuList(id);
        PackageItem newfood = restaurantMenu.getPackagesList().get(i);
        newfood.setItemName(newname);
        restaurantMenu.setforPackagesList(i, newfood);
        restaurantMenu.setforMenuList(j, newfood);
    }

    // 2 - Change Price
    // (i)Main Course
    /**
     * Function to change price of a MainCourse item from exisiting MainCourse list
     * Find MainCourse first,then change price Yield IndexOutOfBounds exception if
     * item not found
     * 
     * @param id       (String) ID of MainCourse to be updated
     * @param newprice (double) New Price of corresponding MainCourse
     */
    public static void changeMainCoursePrice(String id, double newprice) {
        int i = restaurantMenu.findforMainCourseList(id);
        int j = restaurantMenu.findforMenuList(id);
        MainCourse newfood = restaurantMenu.getMainCourseList().get(i);
        newfood.setPrice(newprice);
        restaurantMenu.setforMainCourseList(i, newfood);
        restaurantMenu.setforMenuList(j, newfood);
    }

    // (ii)appetizer
    /**
     * Function to change price of an Appetizer item from existing Appetizer list
     * Find Appetizer first,then change price Yield IndexOutOfBounds exception if
     * item not found
     * 
     * @param id       (String) ID of Appetizer to be updated
     * @param newprice (double) New Price of corresponding Appetizer
     */
    public static void changeAppePrice(String id, double newprice) {
        int i = restaurantMenu.findforAppeList(id);
        int j = restaurantMenu.findforMenuList(id);
        Appetizer newfood = restaurantMenu.getAppeList().get(i);
        newfood.setPrice(newprice);
        restaurantMenu.setforAppeList(i, newfood);
        restaurantMenu.setforMenuList(j, newfood);
    }

    // (iii)drinks
    /**
     * Function to change price of a Drinks item from exisintg Drinks list Find
     * Drinks first,then change price Yield IndexOutOfBounds exception if item not
     * found
     * 
     * @param id       (String) ID of Drinks to be updated
     * @param newprice (double) New Price of corresponding Drinks
     */
    public static void changeDrinksPrice(String id, double newprice) {
        int i = restaurantMenu.findforDrinksList(id);
        int j = restaurantMenu.findforMenuList(id);
        Drinks newfood = restaurantMenu.getDrinksList().get(i);
        newfood.setPrice(newprice);
        restaurantMenu.setforDrinksList(i, newfood);
        restaurantMenu.setforMenuList(j, newfood);
    }

    // (iv)dessert
    /**
     * Function to change price of a Dessert item from existing Dessert list Find
     * Dessert first, then change price Yield IndexOutOfBounds exception if item not
     * found
     * 
     * @param id       (String) ID of Dessert to be updated
     * @param newprice (double) New Price of corresponding Dessert
     */
    public static void changeDessertPrice(String id, double newprice) {
        int i = restaurantMenu.findforDessertList(id);
        int j = restaurantMenu.findforMenuList(id);
        Dessert newfood = restaurantMenu.getDessertList().get(i);
        newfood.setPrice(newprice);
        restaurantMenu.setforDessertList(i, newfood);
        restaurantMenu.setforMenuList(j, newfood);
    }

    // (v)packages
    /**
     * Function to change price of a PackageItem from existing PackageItem list Find
     * PackageItem first, then change price Yield IndexOutOfBounds exception if item
     * not found
     * 
     * @param id       (String) ID of PackageItem to be updated
     * @param newprice (double) New Price of corresponding PackageItem
     */
    public static void changePackagesPrice(String id, double newprice) {
        int i = restaurantMenu.findforPackageList(id);
        int j = restaurantMenu.findforMenuList(id);
        PackageItem newfood = restaurantMenu.getPackagesList().get(i);
        newfood.setPrice(newprice);
        restaurantMenu.setforPackagesList(i, newfood);
        restaurantMenu.setforMenuList(j, newfood);
    }

    // 3)Change description
    // (i)Main Course
    /**
     * Function to change description of a MainCourse item from existing MainCourse
     * list Find MainCourse item first, then change description Yield
     * IndexOutOfBounds exception if item not found
     * 
     * @param id          (String) ID of MainCourse to be updated
     * @param description (String) New description of corresponding MainCourse item
     */
    public static void changeMainCourseDescription(String id, String description) {
        int i = restaurantMenu.findforMainCourseList(id);
        int j = restaurantMenu.findforMenuList(id);
        MainCourse newfood = restaurantMenu.getMainCourseList().get(i);
        newfood.setDescription(description);
        restaurantMenu.setforMainCourseList(i, newfood);
        restaurantMenu.setforMenuList(j, newfood);
    }

    // (ii)Appetizer
    /**
     * Function to change description of an Appetizer item from existing Appetizer
     * list Find Appetizer item first, then change description Yield
     * IndexOutOfBounds exception if item not found
     * 
     * @param id          (String) ID of Appetizer to be updated
     * @param description (String) New description of corresponding Appetizer item
     */
    public static void changeAppetizerDescription(String id, String description) {
        int i = restaurantMenu.findforAppeList(id);
        int j = restaurantMenu.findforMenuList(id);
        Appetizer newfood = restaurantMenu.getAppeList().get(i);
        newfood.setDescription(description);
        restaurantMenu.setforAppeList(i, newfood);
        restaurantMenu.setforMenuList(j, newfood);
    }

    // (iii)Drinks
    /**
     * Function to change description of a Drinks item from existing Drinks list
     * Find Drinks item first,then change description Yield IndexOutOfBounds
     * exception if item not found
     * 
     * @param id          (String) ID of Drinks to be updated
     * @param description (String) New description of corresponding Drinks item
     */
    public static void changeDrinksDescription(String id, String description) {
        int i = restaurantMenu.findforDrinksList(id);
        int j = restaurantMenu.findforMenuList(id);
        Drinks newfood = restaurantMenu.getDrinksList().get(i);
        newfood.setDescription(description);
        restaurantMenu.setforDrinksList(i, newfood);
        restaurantMenu.setforMenuList(j, newfood);
    }

    // (iv)Dessert
    /**
     * Function to change description of a Dessert item from existing Dessert list
     * Find Dessert item first,then change description Yield IndexOutOfBounds
     * exception if item not found
     * 
     * @param id          (String) ID of Dessert to be updated
     * @param description (String) New description of corresponding Dessert item
     */
    public static void changeDessertDescription(String id, String description) {
        int i = restaurantMenu.findforDessertList(id);
        int j = restaurantMenu.findforMenuList(id);
        Dessert newfood = restaurantMenu.getDessertList().get(i);
        newfood.setDescription(description);
        restaurantMenu.setforDessertList(i, newfood);
        restaurantMenu.setforMenuList(j, newfood);
    }

    // (v)Packages
    /**
     * Function to change description of a PackageItem from exisitng PackageItem
     * list Find PackageItem first, then change description Yield IndexOutOfBounds
     * exception if item not found
     * 
     * @param id          (String) ID of PackageItem to be updated
     * @param description (String) New description of corresponding PackageItem
     */
    public static void changePackagesDescription(String id, String description) {
        int i = restaurantMenu.findforPackageList(id);
        int j = restaurantMenu.findforMenuList(id);
        PackageItem newfood = restaurantMenu.getPackagesList().get(i);
        newfood.setDescription(description);
        restaurantMenu.setforPackagesList(i, newfood);
        restaurantMenu.setforMenuList(j, newfood);
    }

}
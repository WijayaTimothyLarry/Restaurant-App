package controllerclass;

import java.util.ArrayList;


import database.Restaurant;
import entityclass.*;
import entityclass.MenuItem.ItemType;

public class MenuMgr {
    private static Menu restaurantMenu = Restaurant.restaurantMenu;

    /**
     * Function to print Item List based on type
     * @param type Type of items to be printed
     */
    public static void showItemList(ItemType type){
        ArrayList<MenuItem> itemList = restaurantMenu.getItemListByType(type);
        if(type==ItemType.APPETIZER){
            System.out.println("          APPETIZER         ");
            System.out.println("******************************");
        }else if(type==ItemType.MAINCOURSE){
            System.out.println("          MAIN COURSE         ");
            System.out.println("******************************");
        }else if(type==ItemType.DESSERT){
            System.out.println("          DESSERT         ");
            System.out.println("******************************");

        }else if(type==ItemType.DRINKS){
            System.out.println("          DRINKS         ");
            System.out.println("******************************");
        }
        if (itemList.size() == 0) {
            System.out.println("This list is empty");
        }
        for (int i = 0; i < itemList.size(); i++) {
            MenuItem item = itemList.get(i);
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
        System.out.println("          MENU          ");
        System.out.println("******************************");
        showItemList(ItemType.APPETIZER);
        showItemList(ItemType.MAINCOURSE);
        showItemList(ItemType.DRINKS);
        showItemList(ItemType.DESSERT);
        showPackage();
    }

    /**
     * Functiont to add an item into MenuList
     * @param menuItem menuItem to be added into MenuList
     */
    public static void addMenuItem(MenuItem menuItem) {
        restaurantMenu.addintoMenuList(menuItem);
        System.out.println("Updated Menu:");
        showItemList(menuItem.getItemType());
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

    public static void addintoPackage(String packageID, String itemID){
        MenuItem menuItem = findItembyID(itemID);
        restaurantMenu.addIntoItemsInPackageList(packageID, menuItem);
    }

    /**
     * Function to delete an Appetizer from existing list based on ID Print "Item
     * not found" if ID doesnt exist
     * 
     * @param id (String)ID of MenuItem to be deleted
     * @see Menu
     */
    public static void removeMenuItem(String id) {
        if (restaurantMenu.removeforMenuList(id) == -1) {
            System.out.println("Item not found\n");
        } else {
            System.out.println("Deleted successfully");
        }
    }

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
            System.out.println("Package deleted successfully");
        }
    }

    /**
     * Function to remove an item from a promo package
     * @param packageID ID of promo package
     * @param itemID ID of item to be removed
     */
    public static void removeiteminPackage(String packageID, String itemID){
        if(restaurantMenu.removeforitemsinPackageList(packageID, itemID)==-1){
            System.out.println("Item not found");
        }
    }


    /**
     * Function to find and return a MenuItem using ID from existing list return
     * IndexOutOfBounds exception if ID not found
     * 
     * @param id (String)ID of MenuItem to be found
     * @return (MenuItem)Corresponding MenuItem based on id
     * @see Menu
     */
    public static MenuItem findItembyID(String id) {
        int i = restaurantMenu.findforMenuList(id);
        return restaurantMenu.getMenuList().get(i);
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



    /**
     * Function to change name of a Menuitem from existing Menuitem list
     * Find Menuitem first, then change name Yield IndexOutOfBounds exception if
     * item not found
     * 
     * @param id      (String)ID of Menuitem to be updated
     * @param newname (String)New Name of corresponding MainCourse
     */
    public static void changeMenuItemName(String id, String newname) {
        int j = restaurantMenu.findforMenuList(id);
        MenuItem newfood = restaurantMenu.getMenuList().get(j);
        newfood.setItemName(newname);
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


    /**
     * Function to change price of a MenuItem item from existing MenuItem list
     * Find Menuitem first,then change price Yield IndexOutOfBounds exception if
     * item not found
     * 
     * @param id       (String) ID of MenuItem to be updated
     * @param newprice (double) New Price of corresponding MainCourse
     */
    public static void changeMenuItemPrice(String id, double newprice) {
        int j = restaurantMenu.findforMenuList(id);
        MenuItem newfood = restaurantMenu.getMenuList().get(j);
        newfood.setPrice(newprice);
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
    /**
     * Function to change description of a Menuitem from existing Menuitem
     * list .Find Menuitem first, then change description Yield
     * IndexOutOfBounds exception if item not found
     * 
     * @param id          (String) ID of MainCourse to be updated
     * @param description (String) New description of corresponding MainCourse item
     */
    public static void changeMenuItemDescription(String id, String description) {
        int j = restaurantMenu.findforMenuList(id);
        MenuItem newfood = restaurantMenu.getMenuList().get(j);
        newfood.setDescription(description);
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
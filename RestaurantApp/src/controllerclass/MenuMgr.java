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

    //Find items
    //1 - Appetizer
    public static Appetizer findAppetizerbyID(String id){
        int i = restaurantMenu.findforAppeList(id);
        return restaurantMenu.getAppeList().get(i);
    }

    //2 - Main Course
    public static MainCourse findMainCoursebyID(String id){
        int i = restaurantMenu.findforMainCourseList(id);
        return restaurantMenu.getMainCourseList().get(i);
    }

    //3 - Drinks
    public static Drinks findDrinksbyID(String id){
        int i = restaurantMenu.findforDrinksList(id);
        return restaurantMenu.getDrinksList().get(i);
    }

    //4 - Dessert
    public static Dessert findDessertbyID(String id){
        int i = restaurantMenu.findforDessertList(id);
        return restaurantMenu.getDessertList().get(i);
    }

    //5 - Packages
    public static PackageItem findPackagebyID(String id){
        int i = restaurantMenu.findforPackageList(id);
        return restaurantMenu.getPackagesList().get(i);
    }

    //Update Items
    //1)Change Name
    //(i) main course
    public static void changeMainCourseName(String id, String newname){
        int i = restaurantMenu.findforMainCourseList(id);
        int j = restaurantMenu.findforMenuList(id);
        MainCourse newfood = restaurantMenu.getMainCourseList().get(i);
        newfood.setItemName(newname);
        restaurantMenu.setforMainCourseList(i,newfood);
        restaurantMenu.setforMenuList(j, newfood);
    }
    //(ii) appetizer
    public static void changeAppetizerName(String id, String newname){
        int i = restaurantMenu.findforAppeList(id);
        int j = restaurantMenu.findforMenuList(id);
        Appetizer newfood = restaurantMenu.getAppeList().get(i);
        newfood.setItemName(newname);
        restaurantMenu.setforAppeList(i,newfood);
        restaurantMenu.setforMenuList(j, newfood);
    }
    //(iii)drinks
    public static void changeDrinksName(String id, String newname){
        int i = restaurantMenu.findforDrinksList(id);
        int j = restaurantMenu.findforMenuList(id);
        Drinks newfood = restaurantMenu.getDrinksList().get(i);
        newfood.setItemName(newname);
        restaurantMenu.setforDrinksList(i,newfood);
        restaurantMenu.setforMenuList(j, newfood);
    }
    //(iv)dessert
    public static void changeDessertName(String id, String newname){
        int i = restaurantMenu.findforDessertList(id);
        int j = restaurantMenu.findforMenuList(id);
        Dessert newfood = restaurantMenu.getDessertList().get(i);
        newfood.setItemName(newname);
        restaurantMenu.setforDessertList(i,newfood);
        restaurantMenu.setforMenuList(j, newfood);
    }
    //(v)packages
    public static void changePackagesName(String id, String newname){
        int i = restaurantMenu.findforPackageList(id);
        int j = restaurantMenu.findforMenuList(id);
        PackageItem newfood = restaurantMenu.getPackagesList().get(i);
        newfood.setItemName(newname);
        restaurantMenu.setforPackagesList(i,newfood);
        restaurantMenu.setforMenuList(j, newfood);
    }

    //2 - Change Price
    //(i)Main Course
    public static void changeMainCoursePrice(String id, double newprice){
        int i = restaurantMenu.findforMainCourseList(id);
        int j = restaurantMenu.findforMenuList(id);
        MainCourse newfood = restaurantMenu.getMainCourseList().get(i);
        newfood.setPrice(newprice);
        restaurantMenu.setforMainCourseList(i,newfood);
        restaurantMenu.setforMenuList(j, newfood);
    }
    //(ii)appetizer
    public static void changeAppePrice(String id, double newprice){
        int i = restaurantMenu.findforAppeList(id);
        int j = restaurantMenu.findforMenuList(id);
        Appetizer newfood = restaurantMenu.getAppeList().get(i);
        newfood.setPrice(newprice);
        restaurantMenu.setforAppeList(i,newfood);
        restaurantMenu.setforMenuList(j, newfood);
    }
    //(iii)drinks
    public static void changeDrinksPrice(String id, double newprice){
        int i = restaurantMenu.findforDrinksList(id);
        int j = restaurantMenu.findforMenuList(id);
        Drinks newfood = restaurantMenu.getDrinksList().get(i);
        newfood.setPrice(newprice);
        restaurantMenu.setforDrinksList(i,newfood);
        restaurantMenu.setforMenuList(j, newfood);
    }
    //(iv)dessert
    public static void changeDessertPrice(String id, double newprice){
        int i = restaurantMenu.findforDessertList(id);
        int j = restaurantMenu.findforMenuList(id);
        Dessert newfood = restaurantMenu.getDessertList().get(i);
        newfood.setPrice(newprice);
        restaurantMenu.setforDessertList(i,newfood);
        restaurantMenu.setforMenuList(j, newfood);
    }
    //(v)packages
    public static void changePackagesPrice(String id, double newprice){
        int i = restaurantMenu.findforPackageList(id);
        int j = restaurantMenu.findforMenuList(id);
        PackageItem newfood = restaurantMenu.getPackagesList().get(i);
        newfood.setPrice(newprice);
        restaurantMenu.setforPackagesList(i,newfood);
        restaurantMenu.setforMenuList(j, newfood);
    }

    //3)Change description
    //(i)Main Course
    public static void changeMainCourseDescription(String id, String description){
        int i = restaurantMenu.findforMainCourseList(id);
        int j = restaurantMenu.findforMenuList(id);
        MainCourse newfood = restaurantMenu.getMainCourseList().get(i);
        newfood.setDescription(description);
        restaurantMenu.setforMainCourseList(i,newfood);
        restaurantMenu.setforMenuList(j, newfood);
    }
    //(ii)Appetizer
    public static void changeAppetizerDescription(String id, String description){
        int i = restaurantMenu.findforAppeList(id);
        int j = restaurantMenu.findforMenuList(id);
        Appetizer newfood = restaurantMenu.getAppeList().get(i);
        newfood.setDescription(description);
        restaurantMenu.setforAppeList(i,newfood);
        restaurantMenu.setforMenuList(j, newfood);
    }
    //(iii)Drinks
    public static void changeDrinksDescription(String id, String description){
        int i = restaurantMenu.findforDrinksList(id);
        int j = restaurantMenu.findforMenuList(id);
        Drinks newfood = restaurantMenu.getDrinksList().get(i);
        newfood.setDescription(description);
        restaurantMenu.setforDrinksList(i,newfood);
        restaurantMenu.setforMenuList(j, newfood);
    }
    //(iv)Dessert
    public static void changeDessertDescription(String id, String description){
        int i = restaurantMenu.findforDessertList(id);
        int j = restaurantMenu.findforMenuList(id);
        Dessert newfood = restaurantMenu.getDessertList().get(i);
        newfood.setDescription(description);
        restaurantMenu.setforDessertList(i,newfood);
        restaurantMenu.setforMenuList(j, newfood);
    }
    //(v)Packages
    public static void changePackagesDescription(String id, String description){
        int i = restaurantMenu.findforPackageList(id);
        int j = restaurantMenu.findforMenuList(id);
        PackageItem newfood = restaurantMenu.getPackagesList().get(i);
        newfood.setDescription(description);
        restaurantMenu.setforPackagesList(i,newfood);
        restaurantMenu.setforMenuList(j, newfood);
    }


}
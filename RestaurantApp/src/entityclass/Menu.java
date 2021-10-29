package entityclass;

import java.io.Serializable;
import java.util.ArrayList;

public class Menu implements Serializable {

	private MainCourse[] mainCourseList;
	private Dessert[] dessertList;
	private Drinks[] drinksList;
	private Appetizer[] appeList;
	private PackageItem[] packageList;
	private ArrayList<MenuItem[]> menuList;

	public Menu() {
		// TODO - implement Menu.Menu
		throw new UnsupportedOperationException();
	}

	public MainCourse[] getMainCourseList() {
		return this.mainCourseList;
	}	
	
	
	public void printMainCourse(){
		System.out.println("          MAIN COURSE          ");
		System.out.println("******************************");
		if(mainCourseList.length==0){
			System.out.println("This list is empty");
		}
		for(int i = 0;i<mainCourseList.length;i++){
			System.out.println("Name: " + mainCourseList[i].getItemName());
			System.out.println("Price: " + mainCourseList[i].getPrice());
			System.out.println("Description: " + mainCourseList[i].getDescription());
			System.out.println("ID: " + mainCourseList[i].getItemID());
			System.out.println("******************************");

		}

	}
	public void printDrinks(){
		System.out.println("          DRINKS         ");
		System.out.println("******************************");
		if(drinksList.length==0){
			System.out.println("This list is empty");
		}
		for(int i = 0;i<drinksList.length;i++){
			System.out.println("Name: " + drinksList[i].getItemName());
			System.out.println("Price: " + drinksList[i].getPrice());
			System.out.println("Description: " + drinksList[i].getDescription());
			System.out.println("ID: " + drinksList[i].getItemID());
			System.out.println("******************************");

		}

	}
	public void printDessert(){
		System.out.println("          DESSERT          ");
		System.out.println("******************************");
		if(dessertList.length==0){
			System.out.println("This list is empty");
		}
		for(int i = 0;i<dessertList.length;i++){
			System.out.println("Name: " + dessertList[i].getItemName());
			System.out.println("Price: " + dessertList[i].getPrice());
			System.out.println("Description: " + dessertList[i].getDescription());
			System.out.println("ID: " + dessertList[i].getItemID());
			System.out.println("******************************");

		}

	}
	public void printAppeList(){
		System.out.println("          APPETIZER          ");
		System.out.println("******************************");
		if(appeList.length==0){
			System.out.println("This list is empty");
		}
		for(int i = 0;i<appeList.length;i++){
			System.out.println("Name: " + appeList[i].getItemName());
			System.out.println("Price: " + appeList[i].getPrice());
			System.out.println("Description: " + appeList[i].getDescription());
			System.out.println("ID: " + appeList[i].getItemID());
			System.out.println("******************************");

		}

	}
	public void printPackage(){
		System.out.println("          SPECIAL PACKAGES         ");
		System.out.println("******************************");
		if(packageList.length==0){
			System.out.println("This list is empty");
		}
		for(int i = 0;i<packageList.length;i++){
			System.out.println("Name: " + packageList[i].getPackageName());
			System.out.println("Price: " + packageList[i].getPackagePrice());
			System.out.println("Description: " + packageList[i].getDescription());
			System.out.println("ID: " + packageList[i].getPackageID());
			System.out.println("******************************");

		}

	}
	/**
	 * 
	 * @param mainCourseList
	 */
	public void setMainCourseList(MainCourse[] mainCourseList) {
		this.mainCourseList = mainCourseList;
	}

	public Dessert[] getDessertList() {
		return this.dessertList;
	}

	/**
	 * 
	 * @param dessertList
	 */
	public void setDessertList(Dessert[] dessertList) {
		this.dessertList = dessertList;
	}

	public Drinks[] getDrinksList() {
		return this.drinksList;
	}

	/**
	 * 
	 * @param drinksList
	 */
	public void setDrinksList(Drinks[] drinksList) {
		this.drinksList = drinksList;
	}

	public PackageItem[] getPackageList() {
		return this.packageList;
	}

	/**
	 * 
	 * @param packageList
	 */
	public void setPackageList(PackageItem[] packageList) {
		this.packageList = packageList;
	}

	public ArrayList<MenuItem[]> getMenuList() {
		// TODO - implement Menu.getMenuList
		return menuList;
	}

}
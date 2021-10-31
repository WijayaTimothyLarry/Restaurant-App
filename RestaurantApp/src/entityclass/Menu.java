package entityclass;

import java.io.Serializable;
import java.util.ArrayList;

public class Menu implements Serializable {

	private ArrayList<MainCourse> mainCourseList;
	private ArrayList<Dessert> dessertList;
	private ArrayList<Drinks> drinksList;
	private ArrayList<Appetizer> appeList;
	private ArrayList<PackageItem> packageList;
	private ArrayList<MenuItem> menuList;

	public Menu(ArrayList<Appetizer> apList, ArrayList<MainCourse> mcList,ArrayList<Dessert> deList,ArrayList<Drinks> drList,ArrayList<PackageItem> paList) {
		// TODO - implement Menu.Menu
		this.appeList = apList;
		this.mainCourseList = mcList;
		this.dessertList = deList;
		this.drinksList = drList;
		this.packageList = paList;
		throw new UnsupportedOperationException();
	}

	public void printMainCourse(){
		System.out.println("          MAIN COURSE          ");
		System.out.println("******************************");
		if(mainCourseList.size()==0){
			System.out.println("This list is empty");
		}
		for(int i = 0;i<mainCourseList.size();i++){
			MainCourse item = mainCourseList.get(i);
			System.out.println("Name: " + item.getItemName());
			System.out.println("Price: " + item.getPrice());
			System.out.println("Description: " + item.getDescription());
			System.out.println("ID: " + item.getItemID());
			System.out.println("******************************");

		}

	}
	public void printDrinks(){
		System.out.println("          DRINKS         ");
		System.out.println("******************************");
		if(drinksList.size()==0){
			System.out.println("This list is empty");
		}
		for(int i = 0;i<drinksList.size();i++){
			Drinks item = drinksList.get(i);
			System.out.println("Name: " + item.getItemName());
			System.out.println("Price: " + item.getPrice());
			System.out.println("Description: " + item.getDescription());
			System.out.println("ID: " + item.getItemID());
			System.out.println("******************************");

		}

	}
	public void printDessert(){
		System.out.println("          DESSERT          ");
		System.out.println("******************************");
		if(dessertList.size()==0){
			System.out.println("This list is empty");
		}
		for(int i = 0;i<dessertList.size();i++){
			Dessert item = dessertList.get(i);
			System.out.println("Name: " + item.getItemName());
			System.out.println("Price: " + item.getPrice());
			System.out.println("Description: " + item.getDescription());
			System.out.println("ID: " + item.getItemID());
			System.out.println("******************************");

		}

	}
	public void printAppeList(){
		System.out.println("          APPETIZER          ");
		System.out.println("******************************");
		if(appeList.size()==0){
			System.out.println("This list is empty");
		}
		for(int i = 0;i<appeList.size();i++){
			Appetizer item = appeList.get(i);
			System.out.println("Name: " + item.getItemName());
			System.out.println("Price: " + item.getPrice());
			System.out.println("Description: " + item.getDescription());
			System.out.println("ID: " + item.getItemID());
			System.out.println("******************************");

		}

	}
	public void printPackage(){
		System.out.println("          SPECIAL PACKAGES         ");
		System.out.println("******************************");
		if(packageList.size()==0){
			System.out.println("This list is empty");
		}
		for(int i = 0;i<packageList.size();i++){
			Appetizer item = appeList.get(i);
			System.out.println("Name: " + item.getItemName());
			System.out.println("Price: " + item.getPrice());
			System.out.println("Description: " + item.getDescription());
			System.out.println("ID: " + item.getItemID());
			System.out.println("******************************");

		}

	}

	public ArrayList<MainCourse> getMainCourseList() {
		return this.mainCourseList;
	}	
	
	
	/**
	 * 
	 * @param mainCourseList
	 */
	public void setMainCourseList(ArrayList<MainCourse> mainCourseList) {
		this.mainCourseList = mainCourseList;
	}

	public ArrayList<Dessert> getDessertList() {
		return this.dessertList;
	}

	/**
	 * 
	 * @param dessertList
	 */
	public void setDessertList(ArrayList<Dessert> dessertList) {
		this.dessertList = dessertList;
	}

	public ArrayList<Drinks> getDrinksList() {
		return this.drinksList;
	}

	/**
	 * 
	 * @param drinksList
	 */
	public void setDrinksList(ArrayList<Drinks> drinksList) {
		this.drinksList = drinksList;
	}

	public ArrayList<PackageItem> getPackageList() {
		return this.packageList;
	}

	/**
	 * 
	 * @param packageList
	 */
	public void setPackageList(ArrayList<PackageItem>  packageList) {
		this.packageList = packageList;
	}
	public ArrayList<Appetizer> getAppeList() {
		return this.appeList;
	}

	/**
	 * 
	 * @param packageList
	 */
	public void setAppeList(ArrayList<Appetizer>  appeList) {
		this.appeList = appeList;
	}

	public ArrayList<MenuItem> getMenuList() {
		// TODO - implement Menu.getMenuList
		return menuList;
	}

}
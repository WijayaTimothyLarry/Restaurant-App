package entityclass;

import java.io.Serializable;
import java.util.*;

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

	/**
	 * 
	 * @param mainCourseList
	 */

	public ArrayList<MainCourse> getMainCourseList() {
		return this.mainCourseList;
	}	
	
	

	public void setMainCourseList(ArrayList<MainCourse> mainCourseList) {
		this.mainCourseList = mainCourseList;
	}

	public int removeforMainCourseList(String id){
		Iterator<MainCourse> itr = mainCourseList.iterator();
		while(itr.hasNext()){
			MainCourse food = itr.next();
			if(food.getItemID()==id){
				System.out.println("Item found");
				itr.remove();
				System.out.println("Item deleted");
				return 1;
			}
		}
		return -1;
	}

	/**
	 * 
	 * @param dessertList
	 */

	public ArrayList<Dessert> getDessertList() {
		return this.dessertList;
	}


	public void setDessertList(ArrayList<Dessert> dessertList) {
		this.dessertList = dessertList;
	}

	public int removeforDessertList(String id){
		Iterator<Dessert> itr = dessertList.iterator();
		while(itr.hasNext()){
			Dessert food = itr.next();
			if(food.getItemID()==id){
				System.out.println("Item found");
				itr.remove();
				System.out.println("Item deleted");
				return 1;
			}
		}
		return -1;

	}


	/**
	 * 
	 * @param drinksList
	 */

	public ArrayList<Drinks> getDrinksList() {
		return this.drinksList;
	}


	public void setDrinksList(ArrayList<Drinks> drinksList) {
		this.drinksList = drinksList;
	}

	public int removeforDrinksList(String id){
		Iterator<Drinks> itr = drinksList.iterator();
		while(itr.hasNext()){
			Drinks food = itr.next();
			if(food.getItemID()==id){
				System.out.println("Item found");
				itr.remove();
				System.out.println("Item deleted");
				return 1;
			}
		}
		return -1;

	}
	/**
	 * 
	 * @param packageList
	 */

	public ArrayList<PackageItem> getPackageList() {
		return this.packageList;
	}

	public void setPackageList(ArrayList<PackageItem>  packageList) {
		this.packageList = packageList;
	}
	public int removeforPackageList(String id){
		Iterator<PackageItem> itr = packageList.iterator();
		while(itr.hasNext()){
			PackageItem food = itr.next();
			if(food.getItemID()==id){
				System.out.println("Item found");
				itr.remove();
				System.out.println("Item deleted");
				return 1;
			}
		}
		return -1;

	}

	/**
	 * 
	 * @param appeList
	 */
	public ArrayList<Appetizer> getAppeList() {
		return this.appeList;
	}

	public void setAppeList(ArrayList<Appetizer>  appeList) {
		this.appeList = appeList;
	}

	public int removeforAppeList(String id){
		Iterator<Appetizer> itr = appeList.iterator();
		while(itr.hasNext()){
			Appetizer food = itr.next();
			if(food.getItemID()==id){
				System.out.println("Item found");
				itr.remove();
				System.out.println("Item deleted");
				return 1;
			}
		}
		return -1;

	}

	public ArrayList<MenuItem> getMenuList() {
		// TODO - implement Menu.getMenuList
		return menuList;
	}

}
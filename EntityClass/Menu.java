import java.util.ArrayList;

public class Menu {

	private MainCourse[] mainCourseList;
	private Dessert[] dessertList;
	private Drinks[] drinksList;
	private PackageItem[] packageList;
	private ArrayList<MenuItem[]> menuList;

	public Menu() {
		// TODO - implement Menu.Menu
		throw new UnsupportedOperationException();
	}

	public MainCourse[] getMainCourseList() {
		return this.mainCourseList;
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
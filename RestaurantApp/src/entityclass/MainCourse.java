package entityclass;

public class MainCourse extends MenuItem {

	/**
	 * Constructor for MenuItem MainCourse Child class of MenuItem
	 * 
	 * @param mcName        (String)Name of MenuItem MainCourse
	 * @param mcPrice       (Double)Price of MenuItem MainCourse
	 * @param mcDescription (String)Description of MenuItem MainCourse
	 * @param mcID          (String)ID of MenuItem MainCourse
	 * @see MenuItem
	 */
	public MainCourse(String mcName, double mcPrice, String mcDescription, String mcID) {
		super(mcName, mcPrice, mcDescription, mcID);
	}
}
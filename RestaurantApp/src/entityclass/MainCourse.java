package entityclass;

public class MainCourse extends MenuItem {
	private static final long serialVersionUID = 7158331826423267423L;
	/**
	 * Constructor for MenuItem MainCourse
	 * Child class of MenuItem
	 * @param mcName (String)Name of MenuItem MainCourse
	 * @param mcPrice (Double)Price of MenuItem MainCourse
	 * @param mcDescription (String)Description of MenuItem MainCourse
	 * @param mcID (String)ID of MenuItem MainCourse
	 * @see MenuItem
	 */
	public MainCourse(String mcName, double mcPrice, String mcDescription, String mcID) {
        super(mcName, mcPrice, mcDescription, mcID);
    }
}
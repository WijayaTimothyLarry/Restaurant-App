package entityclass;

import java.io.Serializable;

public class Person implements Serializable {

	private String name;
	private String gender;

	/**
	 * Constructor for Person class
	 * @param name (String)Name of Person
	 * @param gender (String)Gender of Person
	 */
	public Person(String name, String gender) {
		this.name = name;
		this.gender = gender;
	}

	/**
	 * Function to get the name of Person
	 * @return (String)Name of Person
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Function to set the name of Person
	 * @param name (String)Name of person
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Function to get the gender of Person
	 * @return (String)Gender of Person
	 */
	public String getGender() {
		return this.gender;
	}

	/**
	 * Function to set the gender of Person
	 * @param gender (String)Gender of person
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

}
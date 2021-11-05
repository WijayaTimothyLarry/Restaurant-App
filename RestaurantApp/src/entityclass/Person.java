package entityclass;

import java.io.Serializable;

public class Person implements Serializable {

	private String name;
	private String gender;

	public Person(String name, String gender) {
		this.name = name;
		this.gender = gender;
		// TODO - implement Person.Person

	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return this.gender;
	}

	/**
	 * 
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

}
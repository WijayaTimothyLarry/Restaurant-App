package EntityClass;

import java.io.Serializable;

public class Person implements Serializable {

	private String name;
	private String gender;

	public Person(String nam, String sex) {
		this.name = nam;
		this.gender = sex;
		// TODO - implement Person.Person
		throw new UnsupportedOperationException();
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
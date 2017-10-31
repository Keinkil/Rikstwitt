package riks.unirest.java.beans;

import com.google.gson.annotations.SerializedName;

/**
 * A class to hold an Array of objects from Riksdagens API
 * 
 * @author Rikard Almgren
 * @version 1.0
 *
 */
public class Personlista {
	private Person[] person;
	@SerializedName("@systemdatum")
	private String systemdatum;
	@SerializedName("@hits")
	private String hits;

	/**
	 * A method to return a Person Array
	 * 
	 * @return the Person array
	 */
	public Person[] getPerson() {
		return person;
	}

	/**
	 * A method to set a new Person array
	 * 
	 * @param person
	 *            the Person array
	 */
	public void setPerson(Person[] person) {
		this.person = person;
	}

	/**
	 * A method to retrieve the date as a String
	 * 
	 * @return String, the date
	 */
	public String getSystemdatum() {
		return systemdatum;
	}

	/**
	 * A method to set the date in a String
	 * 
	 * @param systemdatum
	 *            String, the date
	 */
	public void setSystemdatum(String systemdatum) {
		this.systemdatum = systemdatum;
	}

	/**
	 * A method to return the number of hits
	 * 
	 * @return the number of hits contained in a string
	 */
	public String getHits() {
		return hits;
	}

	/**
	 * A method to set the number of hits
	 * 
	 * @param hits
	 *            the number of hits
	 */
	public void setHits(String hits) {
		this.hits = hits;
	}
}

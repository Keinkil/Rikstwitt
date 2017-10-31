package riks.unirest.java.beans;

import com.google.gson.annotations.SerializedName;

/**
 * A class to hold single objects (and not arrays) from Riksdagens API
 * 
 * @author Rikard Almgren
 * @version 1.0
 */
public class Personlista2 {
	private Person person;
	@SerializedName("@systemdatum")
	private String systemdatum;
	@SerializedName("@hits")
	private String hits;

	/**
	 * Method to return date
	 * 
	 * @return String containing date
	 */
	public String getSystemdatum() {
		return systemdatum;
	}

	/**
	 * Method to set date (if necessary)
	 * 
	 * @param systemdatum
	 *            String containing date
	 */
	public void setSystemdatum(String systemdatum) {
		this.systemdatum = systemdatum;
	}

	/**
	 * Method to return hits
	 * 
	 * @return A string containing number of hits
	 */
	public String getHits() {
		return hits;
	}

	/**
	 * Method to set number of hits
	 * 
	 * @param hits
	 *            number of hits
	 */
	public void setHits(String hits) {
		this.hits = hits;
	}

	/**
	 * Method to return a Person object referenced in this object
	 * 
	 * @return the Person object
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * Method to set a new Person object
	 * 
	 * @param person
	 *            The Person object
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

}

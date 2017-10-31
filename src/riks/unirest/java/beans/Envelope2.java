package riks.unirest.java.beans;

/**
 * A container class used with Riksdagens API
 * 
 * @author Rikard Almgren
 * @version 1.0
 *
 */
public class Envelope2 {
	private Personlista2 personlista;

	/**
	 * A method to retrieve a list of people (or more accurately a list of a single
	 * person)
	 * 
	 * @return "list"
	 */
	public Personlista2 getPersonlista() {
		return personlista;
	}

	/**
	 * A method to set a list of people
	 * 
	 * @param personlista
	 *            list
	 */
	public void setPersonlista(Personlista2 personlista) {
		this.personlista = personlista;
	}

}

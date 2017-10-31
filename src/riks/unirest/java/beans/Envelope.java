package riks.unirest.java.beans;

/**
 * A container class used with Riksdagens API
 * 
 * @author Rikard Almgren
 * @version 1.0
 *
 */
public class Envelope {
	private Personlista personlista;
	
	/**
	 * A method to return a list of people
	 * @return
	 */
	public Personlista getPersonlista() {
		return personlista;
	}
	/**
	 * A method to set a list of people
	 * @param personlista
	 */
	public void setPersonlista(Personlista personlista) {
		this.personlista = personlista;
	}

}

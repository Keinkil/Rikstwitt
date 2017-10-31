package riks.unirest.java.beans;

/**
 * A class to hold a Person object retrieved from Riksdagens API
 * 
 * @author Rikard Almgren
 * @version 1.0
 *
 */
public class Person {
	private String fodd_ar;
	private String kon;
	private String efternamn;
	private String tilltalsnamn;
	private String sorteringsnamn;
	private String parti;
	private String valkrets;
	private String status;
	private String bild_url_80;
	private String bild_url_192;
	private String bild_url_max;

	/**
	 * A method to retrieve the year the person was born as a String
	 * 
	 * @return the year the person was born
	 */
	public String getFodd_ar() {
		return fodd_ar;
	}

	/**
	 * A method to set the year the person was born
	 * 
	 * @param fodd_ar
	 *            the year the person was born
	 */
	public void setFodd_ar(String fodd_ar) {
		this.fodd_ar = fodd_ar;
	}

	/**
	 * A method to retrieve the gender of the person
	 * 
	 * @return the gender of the person
	 */
	public String getKon() {
		return kon;
	}

	/**
	 * A method to set the gender of the person
	 * 
	 * @param kon
	 *            the gender of the person
	 */
	public void setKon(String kon) {
		this.kon = kon;
	}

	/**
	 * A method to return the surname of the person
	 * 
	 * @return the surname of the person
	 */
	public String getEfternamn() {
		return efternamn;
	}

	/**
	 * A method to set the surname of the person
	 * 
	 * @param efternamn
	 *            the surname of the person
	 */
	public void setEfternamn(String efternamn) {
		this.efternamn = efternamn;
	}

	/**
	 * A method to retrieve the name by which the person is referred to.
	 * 
	 * @return name
	 */
	public String getTilltalsnamn() {
		return tilltalsnamn;
	}

	/**
	 * A method to set the name by which the person is referred to.
	 * 
	 * @param tilltalsnamn
	 *            name
	 */
	public void setTilltalsnamn(String tilltalsnamn) {
		this.tilltalsnamn = tilltalsnamn;
	}

	/**
	 * A method to retrieve the name the person is sorted by
	 * 
	 * @return name
	 */
	public String getSorteringsnamn() {
		return sorteringsnamn;
	}

	/**
	 * A method to set the name the person is sorted by
	 * 
	 * @param sorteringsnamn
	 *            name
	 */
	public void setSorteringsnamn(String sorteringsnamn) {
		this.sorteringsnamn = sorteringsnamn;
	}

	/**
	 * A method to retrieve what political party the person belongs to
	 * 
	 * @return the party
	 */
	public String getParti() {
		return parti;
	}

	/**
	 * A method to set what political party the person belongs to
	 * 
	 * @param parti
	 *            the party
	 */
	public void setParti(String parti) {
		this.parti = parti;
	}

	/**
	 * A method to retrieve in which area the person is in charge
	 * 
	 * @return area
	 */
	public String getValkrets() {
		return valkrets;
	}

	/**
	 * A method to set in which area the person is in charge
	 * 
	 * @param valkrets
	 *            area
	 */
	public void setValkrets(String valkrets) {
		this.valkrets = valkrets;
	}

	/**
	 * A method to retrieve what their current position in Riksdagen is.
	 * 
	 * @return position
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * A method to set what their current position in Riksdagen is
	 * 
	 * @param status
	 *            position
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * A method to retrieve an image url
	 * 
	 * @return
	 */
	public String getBild_url_80() {
		return bild_url_80;
	}

	/**
	 * A method to set an image url
	 * 
	 * @return
	 */
	public void setBild_url_80(String bild_url_80) {
		this.bild_url_80 = bild_url_80;
	}

	/**
	 * A method to retrieve an image url
	 * 
	 * @return
	 */
	public String getBild_url_192() {
		return bild_url_192;
	}

	/**
	 * A method to set an image url
	 * 
	 * @return
	 */
	public void setBild_url_192(String bild_url_192) {
		this.bild_url_192 = bild_url_192;
	}

	/**
	 * A method to retrieve an image url
	 * 
	 * @return
	 */
	public String getBild_url_max() {
		return bild_url_max;
	}

	/**
	 * A method to set an image url
	 * 
	 * @return
	 */
	public void setBild_url_max(String bild_url_max) {
		this.bild_url_max = bild_url_max;
	}

}

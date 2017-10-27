package riks.unirest.java.beans;

import com.google.gson.annotations.SerializedName;

public class Personlista2 {
	private Person person;
	@SerializedName("@systemdatum")
	private String systemdatum;
	@SerializedName("@hits")
	private String hits;
	
	public Personlista2() {
		
	}

	public String getSystemdatum() {
		return systemdatum;
	}

	public void setSystemdatum(String systemdatum) {
		this.systemdatum = systemdatum;
	}

	public String getHits() {
		return hits;
	}

	public void setHits(String hits) {
		this.hits = hits;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	
}

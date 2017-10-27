package riks.unirest.java.beans;

import com.google.gson.annotations.SerializedName;

public class Personlista {
	@SerializedName("@person")
	private Person person2;
	private Person[] person;
	@SerializedName("@systemdatum")
	private String systemdatum;
	@SerializedName("@hits")
	private String hits;
	
	public Personlista() {
		
	}

	public Person[] getPerson() {
		return person;
	}

	public void setPerson(Person[] person) {
		this.person = person;
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

	public Person getPerson2() {
		return person2;
	}

	public void setPerson2(Person person2) {
		this.person2 = person2;
	}

	
}

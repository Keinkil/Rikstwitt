package riks;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import com.google.gson.Gson;

import riks.unirest.java.beans.Envelope;
import riks.unirest.java.beans.Envelope2;
import riks.unirest.java.beans.Person;
import riks.unirest.java.beans.Personlista;
import riks.unirest.java.beans.Personlista2;

public class RiksCalls {
	private static Personlista personlista = null;
	private static Personlista2 personlista2 = null;

	public static Person[] makeCall(String parti) {
		String party = "";
		if (parti != null) {
			party = parti;
		}
		HttpClient httpclient = null;
		HttpGet httpGet = null;
		HttpResponse response = null;
		StatusLine status = null;
		HttpEntity entity = null;
		InputStream data = null;
		Reader reader = null;

		Gson json = new Gson();

		Envelope envelope = null;
		String url = "http://data.riksdagen.se/personlista/?iid=&fnamn=&enamn=&f_ar=&kn=&parti=" + party
				+ "&valkrets=&rdlstatus=tjanst&org=&utformat=json&termlista=";

		try {
			// Create the client that will call the API
			httpclient = HttpClients.createDefault();
			httpGet = new HttpGet(url);

			// Call the API and verify that all went well
			response = httpclient.execute(httpGet);
			status = response.getStatusLine();
			if (status.getStatusCode() == 200) {
				// All went well. Let's fetch the data
				entity = response.getEntity();
				data = entity.getContent();

				try {
					// Attempt to parse the data as JSON
					reader = new InputStreamReader(data);
					envelope = json.fromJson(reader, Envelope.class);
					personlista = envelope.getPersonlista();

					// Print the info
					printPersonlista(personlista);

					
					/**
					 * Testcode
					 */
					// System.out.println();
					// for (int i = 0; i < personlista.getPerson().length; i++) {
					// System.out.println("-------------------------------------------------------");
					// printPerson(personlista.getPerson()[i]);
					// }
					
					
				} catch (Exception e) {
					// Something didn't go well. No calls for us.
					e.printStackTrace();
					System.out.println("Failed to execute proper request or bad answer");
				}
			} else {
				// Something didn't go well. No calls for us.
				System.out.println("Failed to execute proper request or bad answer");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return personlista.getPerson();
	}
	
	public static Person makeCallS(String parti) {
		String party = "";
		if (parti != null) {
			party = parti;
		}
		HttpClient httpclient = null;
		HttpGet httpGet = null;
		HttpResponse response = null;
		StatusLine status = null;
		HttpEntity entity = null;
		InputStream data = null;
		Reader reader = null;

		Gson json = new Gson();

		Envelope2 envelope = null;
		String url = "http://data.riksdagen.se/personlista/?iid=&fnamn=&enamn=&f_ar=&kn=&parti=" + party
				+ "&valkrets=&rdlstatus=&org=&utformat=json&termlista=";
		if(parti.contains("statsministern")) {
			url = "http://data.riksdagen.se/personlista/?iid=0218878014918&utformat=json";
		}

		try {
			// Create the client that will call the API
			httpclient = HttpClients.createDefault();
			httpGet = new HttpGet(url);

			// Call the API and verify that all went well
			response = httpclient.execute(httpGet);
			status = response.getStatusLine();
			if (status.getStatusCode() == 200) {
				// All went well. Let's fetch the data
				entity = response.getEntity();
				data = entity.getContent();

				try {
					// Attempt to parse the data as JSON
					reader = new InputStreamReader(data);
					envelope = json.fromJson(reader, Envelope2.class);
					personlista2 = envelope.getPersonlista();

					// Print the info
					printPersonlista(personlista2);

					
					/**
					 * Testcode
					 */
					// System.out.println();
					// for (int i = 0; i < personlista.getPerson().length; i++) {
					// System.out.println("-------------------------------------------------------");
					// printPerson(personlista.getPerson()[i]);
					// }
					
					
				} catch (Exception e) {
					// Something didn't go well. No calls for us.
					e.printStackTrace();
					System.out.println("Failed to execute proper request or bad answer");
				}
			} else {
				// Something didn't go well. No calls for us.
				System.out.println("Failed to execute proper request or bad answer");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return personlista2.getPerson();
	}

	public static void printPersonlista(Personlista personlista) {

		System.out.println("Datum: " + personlista.getSystemdatum());
		System.out.println("Antal Ledamöter: " + personlista.getHits());
	}
	
	public static void printPersonlista(Personlista2 personlista) {

		System.out.println("Datum: " + personlista.getSystemdatum());
		System.out.println("Antal Ledamöter: " + personlista.getHits());
	}

	public static void printPerson(Person person) {
		System.out.println("Namn: " + person.getTilltalsnamn() + " " + person.getEfternamn());
		System.out.println("Ålder: " + (2017 - Integer.parseInt(person.getFodd_ar())));
		System.out.println("Parti: " + person.getParti());
		System.out.println("Status: " + person.getStatus());
		System.out.println("Valkrets: " + person.getValkrets());
	}

	public static Person[] getPerson() {
		makeCall("");
		return personlista.getPerson();
	}

	public static void main(String[] args) {
		RiksCalls.makeCall("");
	}
}

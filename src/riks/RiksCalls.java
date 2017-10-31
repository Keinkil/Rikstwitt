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
import com.google.gson.GsonBuilder;

import riks.unirest.java.beans.Envelope;
import riks.unirest.java.beans.Envelope2;
import riks.unirest.java.beans.Person;
import riks.unirest.java.beans.Personlista;
import riks.unirest.java.beans.Personlista2;

/**
 * A class that handles and makes requests to Riksdagens API
 * 
 * @author Rikard Almgren
 * @version 1.0
 */
public class RiksCalls {
	private static Personlista personlista = null;
	private static Personlista2 personlista2 = null;

	/**
	 * A method that makes a call to Riksdagens API to retrieve information about
	 * people in a specific political party (or all parties if in-parameter is null
	 * or blank).
	 * 
	 * @param parti
	 *            political party
	 * @return an array of Person objects
	 */
	public static Person[] makeCall(String parti) {
		String party = "";
		// check if null
		if (parti != null) {
			party = parti;
		}
		// create necessary objects to handle and make request
		HttpClient httpclient = null;
		HttpGet httpGet = null;
		HttpResponse response = null;
		StatusLine status = null;
		HttpEntity entity = null;
		InputStream data = null;
		Reader reader = null;

		Gson json = new Gson();

		Envelope envelope = null;
		/*
		 * The basic request URL from Riksdagens API. We currently only ever request
		 * lists of political parties but the same URL can be modified to make more
		 * requests
		 */
		String url = "http://data.riksdagen.se/personlista/?iid=&fnamn=&enamn=&f_ar=&kn=&parti=" + party
				+ "&valkrets=&rdlstatus=tjanst&org=&utformat=json&termlista=";

		// Attempt to connect to the API and retrieve the information
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
					reader = new InputStreamReader(data, "UTF-8");
					envelope = json.fromJson(reader, Envelope.class);
					personlista = envelope.getPersonlista();

					// Print the info to console to check request ( Not necessary, but can be used
					// to check response while testing
					printPersonlista(personlista);

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
		// return the array
		return personlista.getPerson();
	}

	// This does exactly the same thing as the above method except it (optimally)
	// only retrieves a single person object. That of the Prime Minister.
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

		// Hijack the URl and change it to ask specifically for the prime minister.
		if (parti.contains("statsministern")) {
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

				} catch (Exception e) {
					// Something didn't go well. No calls for us.
					e.printStackTrace();
					System.out.println("Failed to execute proper request or bad answer");
				}
			} else {
				// Something didn't go well. No calls for us.
				System.out.println("Failed to execute proper request or bad answer");
			}
			// uh oh, something else went wrong. Check the trace to find out
		} catch (IOException e) {
			e.printStackTrace();
		}

		return personlista2.getPerson();
	}

	// Test/Confirmation methods
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
		Gson gson = new GsonBuilder().create();
		String jsonArray = gson.toJson(RiksCalls.makeCallS("statsministern"));
		System.out.println(jsonArray);
	}
}

package controller;

import static spark.Spark.get;
import static spark.Spark.port;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import riks.RiksCalls;
import twitt.TwittCalls;
import twitt.TwittMap;

/**
 * A controller class. Receives requests and acts upon them Uses Spark to handle
 * HTTP requests and Google Gson to return JSONs
 * 
 * @author Rikard Almgren
 * @version 1.0
 *
 */
public class RiksTwittController {
	/**
	 * Main method. Let's start the server
	 * 
	 * @param args
	 * @throws Exception
	 *             Something went wrong
	 */
	public static void main(String[] args) throws Exception {
		// Set Spark to listen on port 5000.
		port(5000);

		/*
		 * request for political party information. Send an API call to Riksdagen using
		 * RiksCalls
		 */
		get("/parti/:id", (req, res) -> {
			res.type("application/json"); // set response to json
			res.header("Access-Control-Allow-Origin", "*"); // Prevent errors due to requests from foreign origin
			String id = req.params(":id"); // Find out what party they want information from
			Gson gson = new GsonBuilder().create(); // Create a new GSON builder to transform result into a json
			/*
			 * if the ID was in fact not a party but simply contained "statsministern"
			 * instead make a call to request only the single object of the prime minister
			 */
			if (id.contains("statsministern")) {
				String jsonArray = gson.toJson(RiksCalls.makeCallS(id));
				return jsonArray;
			} else {
				String jsonArray = gson.toJson(RiksCalls.makeCall(id));
				return jsonArray;
			}

		});
		/*
		 * request for tweets, send an API call to twitter using TwittCalls
		 */
		get(":id/tweets", (req, res) -> {

			String id = req.params(":id"); // find out what/who they want to know about
			res.type("application/json"); // set response to json
			res.header("Access-Control-Allow-Origin", "*"); // Prevent errors due to requests from foreign origin
			System.out.println("Request received"); // Hey, we got the request
			Gson gson = new GsonBuilder().create(); // Create a new GSON builder to transform result into a json
			id = TwittMap.check(id); // Check if the ID requested is one of our pre-mapped twitter users
			String jsonArray = gson.toJson(TwittCalls.makeTwittCall(id));
			return jsonArray;

		});
	}

}

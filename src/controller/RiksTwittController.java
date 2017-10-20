package controller;

import static spark.Spark.get;
import static spark.Spark.port;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import riks.RiksCalls;
import twitt.TwittCalls;


public class RiksTwittController {

		
	public static void main(String[] args) throws Exception {
		port(5000);
		
		
		get("/parti/:id", (req, res) -> {
			res.type("application/json");
			res.header("Access-Control-Allow-Origin", "*");
			String id = req.params(":id");
			//System.out.println(req.headers());
			System.out.println("Request received");
			Gson gson=new GsonBuilder().create();
		    String jsonArray=gson.toJson(RiksCalls.makeCall(id));
			return jsonArray;		
				
		});
		
		get("/", (req, res) -> {
			res.header("Access-Control-Allow-Origin", "*");
			System.out.println("hello");
			return "hello";
				
		});
		
		get(":id/tweets", (req, res) -> {

			String id = req.params(":id");
			res.type("application/json");
			res.header("Access-Control-Allow-Origin", "*");
			System.out.println("Request received");
			Gson gson = new GsonBuilder().create();
			String jsonArray = gson.toJson(TwittCalls.makeTwittCall(id));
			return jsonArray;

		});
		
		// 	SearchUsers.SearchUser("Jan Björklund");
	}

}

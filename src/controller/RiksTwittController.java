package controller;

import static spark.Spark.get;
import static spark.Spark.port;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import riks.RiksCalls;


public class RiksTwittController {

	public static void main(String[] args) throws Exception {
		port(5000);
		
		// A demonstration of how to use code within an endpoint
//		get("/", (req, res) -> {
//			return "hello";
//		});
		
		 
		    
//		get("/1", (req, res) -> {
//			System.out.println("Request received");
//			Gson gson=new GsonBuilder().create();
//		    String jsonArray=gson.toJson(RiksCalls.getPerson());
//			return jsonArray;
//				
//		});
		
		get("/1", (req, res) -> {
			System.out.println(req.headers());
			System.out.println("Request received");
			Gson gson=new GsonBuilder().create();
		    String jsonArray=gson.toJson(RiksCalls.getPerson());
			return jsonArray;
				
		});
		
		get("/", (req, res) -> {
			System.out.println("Request received");
			Gson gson=new GsonBuilder().create();
		    String jsonArray=gson.toJson(RiksCalls.getPerson());
			return RiksCalls.getPerson();
				
		});
	}

}

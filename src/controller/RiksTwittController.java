package controller;

import static spark.Spark.get;
import static spark.Spark.port;

import riks.RiksCalls;


public class RiksTwittController {

	public static void main(String[] args) throws Exception {
		port(5000);
		
		// A demonstration of how to use code within an endpoint
		get("/", (req, res) -> {
			return "hello";
		});
		
		get("/ledamoter", (req, res) -> {
			return RiksCalls.getPerson();
		});
	}

}

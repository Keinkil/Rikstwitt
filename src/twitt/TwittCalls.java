package twitt;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 * A class to retrieve twitter messages based on a query
 * 
 * @author Yusuke Yamamoto, Rikard Almgren
 * @version 1.0
 */
public class TwittCalls {

	/**
	 * The method makeTwittCall receives a string as an in-parameter and makes a
	 * query to the twitter API based on the string.
	 * 
	 * @param Query
	 *            String, what you would like messages to contain (examples are
	 *            names or locations or just keywords)
	 * @return A list of tweet results
	 */
	public static List<Status> makeTwittCall(String Query) {
		/*
		 * Attempts to create a new connection to twitter create a query based on
		 * in-parameter attempt to retrieve the most recent messages and save these to a
		 * list
		 */
		Twitter twitter = new TwitterFactory().getInstance();
		List<Status> tweets = null;
		Query query = new Query(Query);
		query.setResultType(twitter4j.Query.RECENT);
		try {
			QueryResult result = twitter.search(query);
			tweets = result.getTweets();
			// If the twitterAPI returns an error, print the error, close.
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to search tweets: " + te.getMessage());
			System.exit(-1);
		}
		// return a list of tweets
		return tweets;
	}

	// for testing this individual class
	public static void main(String[] args) throws TwitterException {
		Gson gson = new GsonBuilder().create();
		String jsonArray = gson.toJson(TwittCalls.makeTwittCall("Stefan Löfven").get(0));
		System.out.println(jsonArray);
	}

}

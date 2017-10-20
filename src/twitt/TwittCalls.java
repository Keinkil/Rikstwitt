package twitt;

import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class TwittCalls {

	public static List<Status> makeTwittCall(String Query) throws TwitterException {
        Twitter twitter = new TwitterFactory().getInstance();
        List<Status> tweets = null;
        Query query = new Query(Query);
        try {
        QueryResult result = twitter.search(query);
        tweets = result.getTweets();
        } catch(TwitterException te) {
        	te.printStackTrace();
        	System.out.println("Failed to search tweets: " + te.getMessage());
        	System.exit(-1);
        }
        return tweets;
	}

}

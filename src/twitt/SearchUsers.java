package twitt;

import twitter4j.ResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

/**
 * A class to search for twitter users. Not used
 * 
 * @author Yusuke Yamamoto(Twitter4j), Rikard Almgren
 * @version 0.1
 *
 */
public final class SearchUsers {

	/**
	 * The method SearchUser connects to the twitterAPI and searches for a user
	 * given in the in-parameter
	 * 
	 * @param args User to search for
	 */
	public static void SearchUser(String args) {
		// No one has a 0-length or less username.
		if (args.length() < 1) {
			System.out.println("Usage: java twitter4j.examples.user.SearchUsers [query]");
			System.exit(-1);
		}
		/* Attempts to create a new connection to twitter, receive a paged list of users
		* and print them.
		* If this class had been used this would instead have returned a list.
		*/
		try {
			Twitter twitter = new TwitterFactory().getInstance();
			int page = 1;
			ResponseList<User> users;
			users = twitter.searchUsers(args, page);
			for (User user : users) {
				System.out.println("@" + user.getScreenName());
			}
			System.out.println("done.");
			// If the twitterAPI returns an error, print the error, close.
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to search users: " + te.getMessage());
			System.exit(-1);
		}
	}
}
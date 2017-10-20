package twitt;

import twitter4j.ResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

public final class SearchUsers {

	public static void SearchUser(String args) {
		if (args.length() < 1) {
			System.out.println("Usage: java twitter4j.examples.user.SearchUsers [query]");
			System.exit(-1);
		}
		try {
			Twitter twitter = new TwitterFactory().getInstance();
			int page = 1;
			ResponseList<User> users;
				users = twitter.searchUsers(args, page);
				for (User user : users) {
						System.out.println("@" + user.getScreenName());
					}
			System.out.println("done.");
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to search users: " + te.getMessage());
			System.exit(-1);
		}
	}

	public static void main(String[] args) {

	}
}
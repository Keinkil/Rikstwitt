package twitt;

import java.io.InputStream;
import java.io.Reader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

public class TwittCalls {
	
	String url = "http://api.sr.se/api/v2/playlists/rightnow?channelid=2576&format=json";
	
	HttpClient httpclient = null;
	HttpGet httpGet = null;
	HttpResponse response = null;
	StatusLine status = null;
	HttpEntity entity = null;
	InputStream data = null;
	Reader reader = null;

}

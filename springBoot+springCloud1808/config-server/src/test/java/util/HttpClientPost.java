package util;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClientPost {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		String url = "http://localhost:7020/actuator/refresh";
		HttpPost httpPost = new HttpPost(url);
		CloseableHttpClient client = HttpClients.createDefault();
		
		client.execute(httpPost);
	}

}

package work.lycwood.ipproxy;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Test02 {
	
	public static void main(String[] args) {
	    proxy();    
		
		
	}
	
	public static void proxy() {
		
		
		HttpHost proxy = new HttpHost("119.101.117.72", 9999);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet get = new HttpGet("http://2018.ip138.com/ic.asp");
		RequestConfig config = RequestConfig.custom().setProxy(proxy).setConnectTimeout(3000).setSocketTimeout(2000).build();
		get.setConfig(config);
		try {
			CloseableHttpResponse response = httpClient.execute(get);
			HttpEntity entity = response.getEntity();
			String body = EntityUtils.toString(entity, "gbk");
			System.out.println(body);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void atomicInteger() {
		AtomicInteger pointer = new AtomicInteger(1);
		int p = pointer.incrementAndGet();
		int size = 10;
		if (p < size) {
			System.out.println(p);
		}
		while (!pointer.compareAndSet(p, p % size)) {
			p = pointer.get();
		}
		System.out.println( p % size);
		
	}
}

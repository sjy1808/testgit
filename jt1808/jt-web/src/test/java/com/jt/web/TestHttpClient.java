package com.jt.web;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class TestHttpClient {

	//测试远程访问tmooc
	/**
	 * 步骤
	 * 	1.定义httpClient请求对象
	 * 	2.定义访问url地址
	 * 	3.定义请求类型.get/post/put
	 * 	4.发起请求,获取返回值结果
	 * 	5.判断返回值的状态是否为200
	 * 	6.解析返回值.
	 * @throws Exception 
	 * @throws ClientProtocolException 
	 */
	@Test
	public void testGet() throws ClientProtocolException, Exception{
		CloseableHttpClient client = HttpClients.createDefault();
		String url="https://www.taobao.com";
		HttpGet get=new HttpGet(url);
		CloseableHttpResponse response = client.execute(get);
		if(response.getStatusLine().getStatusCode()==200){
			String result=EntityUtils.toString(response.getEntity());
			System.out.println(result);
		}
		
	}
}

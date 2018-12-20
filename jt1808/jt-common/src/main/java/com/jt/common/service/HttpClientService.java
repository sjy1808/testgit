package com.jt.common.service;


import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HttpClientService {

    @Autowired(required=false)
    private CloseableHttpClient httpClient;//超时时间

    @Autowired(required=false)
    private RequestConfig requestConfig;

    //编辑请求发送的方式,获取返回值的结果给调用者.
    public String doGet(String url,Map<String,String> params,String charset){
    	String result=null;
    	//1.判断字符集编码是否为null
    	if(StringUtils.isEmpty(charset)){
    		charset="UTF-8";
    	}
    	//2.封装用户提交的参数
    	//http://manage.jt.com?id=1&name=tom...
    	if(params!=null){
    		/*//拼接url
    		url=url+"?";
    		//遍历map集合
    		for (Map.Entry<String, String> entry : params.entrySet()) {
				String key=entry.getKey();
				String value=entry.getValue();
				url=url+key+"="+value+"&";
			}
    		url=url.substring(0,url.length()-1);*/
    		try {
				URIBuilder builder = new URIBuilder(url);
				for (Map.Entry<String, String> entry : params.entrySet()) {
					builder.addParameter(entry.getKey(), entry.getValue());
				}
				url=builder.build().toString();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
    	}
    	//3.封装请求参数类型
    	HttpGet httpGet = new HttpGet(url);
    	try {
    		//4.发起请求,获取响应结果
			CloseableHttpResponse response = httpClient.execute(httpGet);
			//5.判断返回值是否正确
			if(response.getStatusLine().getStatusCode()==200){
				//6.解析返回值数据,按照指定的格式进行解析
				result=EntityUtils.toString(response.getEntity(),charset);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return result;
    	
    }
    public String doGet(String url){
    	return doGet(url, null, null);
    }
    public String doGet(String url,Map<String,String> params){
    	return doGet(url, params, null);
    }
    public String doGet(String url,String charset){
    	return doGet(url, null, charset);
    }
    
    /**
     * 1.定义请求方式httpPost
     * 2.将参数进行表单实体封装
     * 3.发起url请求,获取返回值
     * @param url
     * @param params
     * @param charset
     * @return
     */
    public String doPost(String url,Map<String,String> params,String charset){
    	String result=null;
    	if(StringUtils.isEmpty(charset)){
    		charset="UTF-8";
    	}
    	//1.定义请求类型
    	HttpPost post = new HttpPost(url);
    	post.setConfig(requestConfig);//定义连接的时长
    	
    	//2.参数封装
    	try {
	    	if(params!=null){
	    		List<BasicNameValuePair> parameters=new ArrayList<>();
	    		//动态获取用户数据
	    		for (Map.Entry<String, String> entry : params.entrySet()) {
					parameters.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
				}
	    		//封装FORM表单实体对象,作用传递参数
	    		UrlEncodedFormEntity entity;
	    		entity = new UrlEncodedFormEntity(parameters,charset);
	    		post.setEntity(entity);
			}
	    	//3.发起url请求
	    	CloseableHttpResponse response = httpClient.execute(post);
	    	//4.判断返回值是否正确
	    	if(response.getStatusLine().getStatusCode()==200){
	    		//5.解析返回值数据,按照指定的格式进行解析
	    		result=EntityUtils.toString(response.getEntity(),charset);
	    	}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return result;
    }	
    public String doPost(String url){
    	return doPost(url, null, null);
    }
    public String doPost(String url,Map<String,String> params){
    	return doPost(url, params, null);
    }
    public String doPost(String url,String charset){
    	return doPost(url, null, charset);
    }	
}

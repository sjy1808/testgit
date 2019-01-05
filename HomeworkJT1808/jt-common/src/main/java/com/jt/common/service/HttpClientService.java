package com.jt.common.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

import com.alibaba.druid.util.StringUtils;

@Service
public class HttpClientService {

    @Autowired(required=false)
    private CloseableHttpClient httpClient;//操作http请求API

    @Autowired(required=false)
    private RequestConfig requestConfig;//定义请求超时时间
    /**
     * //拼接url
    		url=url+"?";
    		//遍历map集合
    		for (Map.Entry<String,String> entry : params.entrySet()) {
				String key=entry.getKey();
				String value=entry.getValue();
				url=url+key+"="+value+"&";
			}
    		url=url.substring(0,url.length()-1);
     * @param url
     * @param params
     * @param charset
     * @return
     */
    //编辑请求发送的方式,获取返回值结果 给调用者.
    public String doGet(String url,Map<String,String> params,String charset){
    	String result=null;
    	//1.判断字符集编码是否为null
    	if(StringUtils.isEmpty(charset)){
    		charset="UTF-8";
    	}
    	
    	//2.封装用户提交参数
    	if(params!=null){
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
    	//3.封装请求参数
    	HttpGet httpGet = new HttpGet(url);
    	//4.发起请求,获取响应结果
    	try {
			CloseableHttpResponse response = httpClient.execute(httpGet);
			//5.判断返回值是否正确
			if(response.getStatusLine().getStatusCode()==200){
				//6.解析返回值数据
				result=EntityUtils.toString(response.getEntity(), charset);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	return result;
    }
    //7.构造方法
    public String doGet(String url){
    	return doGet(url,null,null);
    }
    public String doGet(String url,Map<String,String> params){
    	return doGet(url,params,null);
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
    	//1.定义请求方式
    	HttpPost post = new HttpPost(url);
    	post.setConfig(requestConfig);//定义连接时长
    	try {
			//2.封装参数
    		if(params!=null){
    			List<BasicNameValuePair> parameters=new ArrayList<>();
    			//动态获取用户数据
    			for(Map.Entry<String, String> entry:params.entrySet()){
    				parameters.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
    			}
    			UrlEncodedFormEntity entity=new UrlEncodedFormEntity(parameters,charset);
    			post.setEntity(entity);
    		}
    		CloseableHttpResponse httpResponse = httpClient.execute(post);
    		if(httpResponse.getStatusLine().getStatusCode()==200){
    			result=EntityUtils.toString(httpResponse.getEntity(),charset);
    			
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return result;
    }
    public String doPost(String url,Map<String,String> params){
    	return doPost(url,params,null);
    }
    public String doPost(String url){
    	return doPost(url,null,null);
    }
    
}

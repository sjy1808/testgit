package cn.tedu.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 这个类用来封装请求的数据
 * 1.封装三个请求参数,提供setter getter方法
 * 2.在构造函数中传入输入流对象,并给参数赋值
 * 
 */
public class HttpRequest {
	//1.封装三个请求参数,并提供setter getter方法
	//请求方式
	private String method;
	//请求路径
	private String uri;
	//请求要遵循的协议版本号
	private String protocol;
	
	//声明paraMap,存放请求的参数和参数值
	private Map<String,String> paraMap=new HashMap<String,String>();
	
	
	//2.在构造函数中,传入输入流对象,并给参数赋值
	public HttpRequest(InputStream in){
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line=reader.readLine();
			if(line!=null&&line.length()>0){
				String[] strs=line.split(" ");
				method=strs[0];
				uri=strs[1];
				if(uri!=null&&uri.contains("?")){
					String[] s1=uri.split("\\?");
					String s2=s1[1];
					String[] s3=s2.split("&");
					for(String s4:s3){
						String key=s4.split("=")[0];
						String value=s4.split("=")[1];
						paraMap.put(key, value);
					}
				}
				if(uri.equals("/")){
					uri="/index.html";
				}
				protocol=strs[2];
				
				//
				
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getParameter(String key) {
		String value=paraMap.get(key);
		return value;
	}
	
}

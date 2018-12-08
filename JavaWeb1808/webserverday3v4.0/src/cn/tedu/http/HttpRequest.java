package cn.tedu.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 这个类用来封装请求的数据 
 * GET / HTTP/1.1
 */
public class HttpRequest {
	
	//请求方式
	private String method;
	
	//请求资源的路径
	//url:http://localhost:8080/index.html
	//uri:/index.html
	private String uri;
	
	//请求要遵循的协议名版本号
	private String protocol;
	
	//声明一个paraMap,存放请求的参数和参数值
	private Map<String,String> paraMap=new HashMap<>();

	//在构造函数中,传入输入流对象,并给参数赋值
	public HttpRequest(InputStream in){
		try {
			//获取请求信息
			BufferedReader reader=new BufferedReader(new InputStreamReader(in));
			
			//获取请求行
			String line=reader.readLine();
			
			if(line!=null&&line.length()>0){
				
				//按照空格切割字符串然后赋值
				String[] strs=line.split(" ");
				
				method=strs[0];
				uri=strs[1];
				
				//给网站设置默认主页
				if(uri.equals("/")){
					uri="/index.html";
				}
				
				protocol=strs[2];
				
				//uri:/LoginUser?username=sd&password=cxv
				if(uri!=null&&uri.contains("?")){
					//[LoginUser,username=sd&password=cxv]
					String[] s1=uri.split("\\?");
					
					//[username=sd&password=cxv]
					String s2=s1[1];
					
					//[username=sd,password=cxv]
					String[] s3=s2.split("&");
					
					for(String s4:s3){
						//username=sd
						String key=s4.split("=")[0];
						String value=s4.split("=")[1];
						//存入map
						paraMap.put(key,value);
					}
				}
				
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String getParameter(String key){
		String value=paraMap.get(key);
		return value;
	}
	
	//getters and setters
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
	
	
	
	
}

package cn.tedu.http;

import java.io.OutputStream;
import java.io.PrintStream;

import cn.tedu.common.HttpContext;

/**
 * 这个类用来封装响应信息
 * 1.封装四个响应参数
 * 2.在构造函数中传入OutputStream
 * 3.改造getOutputStream方法
 */
public class HttpResponse {
	//1.封装4个响应参数
	//遵循的协议名和版本号
	private String protocol;
	
	//状态码
	private int status;
	
	//响应头Content-Type
	private String contentType;
	
	//响应头Content-Length
	private int contentLength;

	//getters和setters
	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public int getContentLength() {
		return contentLength;
	}

	public void setContentLength(int contentLength) {
		this.contentLength = contentLength;
	}
	
	//2.在构造函数中传入OutputStream
	private OutputStream outputStream;
	//3.改造getOutputStream方法
	//提取响应代码:拼接响应头的
	//必须保证响应头只被发送一次
	boolean isSend;//默认值是false
	public OutputStream getOutputStream() {
		if(!isSend){
			PrintStream ps=new PrintStream(outputStream);
			
			//拼接状态行
//			ps.println(protocol+" "+status+" "OK);
			ps.println(protocol+" "+status+" "+HttpContext.descMap.get(status));
			
			//拼接响应头Content-Type
			ps.println("Content-Type:"+contentType);
			
			//拼接响应头Content-Length
			ps.println("Content-Length:"+contentLength);
			
			//拼接空白行
			ps.println();
			isSend=true;
		}
		
		return outputStream;
	}

	public void setOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
	}
	//在构造函数中初始化
	public HttpResponse(OutputStream outputStream){
		this.outputStream=outputStream;
	}
	
	
	
	
	
}

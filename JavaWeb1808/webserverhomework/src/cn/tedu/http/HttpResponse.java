package cn.tedu.http;

import java.io.OutputStream;
import java.io.PrintStream;

import cn.tedu.common.HttpContext;

/**
 * 这个类用来封装响应信息
 * 1.封装4个响应参数
 * 2.在构造函数中传入 OutputStream
 * 3.改造getOutputStream
 */
public class HttpResponse {
	//1.封装4个相应参数
	//遵循的协议名和版本号
	private String protocol;
	//状态码
	private int status;
	//响应头Content-Type
	private String contentType;
	//响应头Content-Length
	private int contentLength;
	//2.在构造函数中传入OutputStream
	private OutputStream outputStream;
	

	public HttpResponse(OutputStream outputStream) {
		// TODO Auto-generated constructor stub
		this.outputStream=outputStream;
	}


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
	//3.改造getOutputStream
	/*
	 * 提取响应代码:拼接响应头
	 * 必须保证响应头只被发送一次
	 */
	boolean isSend;//默认false
	public OutputStream getOutputStream() {
		if(!isSend){//只执行一次
			PrintStream ps=new PrintStream(outputStream);
			//拼接状态行
//			ps.println(protocol+" "+status+" OK");
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

}

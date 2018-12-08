package cn.tedu.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 这个类用来封装服务器相关的参数信息
 * 1.创建ServletContext对象,读取xml的数据
 * 2.创建静态码块完成封装
 */
public class ServletContext {
	//1.声明和web.xml对应的参数
	//端口号
	public static int port;
	//最大线程数
	public static int maxSize;
	//协议名和版本号
	public static String protocol;
	//资源管理的根目录
	public static String webRoot;
	
	
	//声明一个notfound属性
	public static String notfound;
	
	//存放content-type的值
	public static Map<String,String> typeMap=new HashMap<String,String>();
	
	
	//2.在静态代码块中完成赋值
	static{
		init();
	}
	//利用dom4j技术解析xml
	private static void init() {
		try {
			//SAXReader解析xml的工具类
			SAXReader reader=new SAXReader();
			//读取指定位置的文件
			Document doc=reader.read("config/web.xml");
			//获取根元素server
			Element server=doc.getRootElement();
			//获取子元素service
			Element service=server.element("service");
			//获取孙子元素connector
			Element connector=service.element("connector");
			//获取port属性的值并给成员变量赋值
			port=Integer.parseInt(connector.attributeValue("port"));
			//获取maxSize属性的值并给成员变量赋值
			maxSize=Integer.parseInt(connector.attributeValue("maxSize"));
			//获取protocol属性的值并给成员变量赋值
			protocol=connector.attributeValue("protocol");
			//获取webRoot标签的值并给成员变量赋值
			webRoot=service.elementText("webRoot");
			
			//为notfound属性赋值
			notfound=service.elementText("notfoundpage");
			
			//解析xml中type-mappings的值
			List<Element> list =server.element("type-mappings").elements();
			//map(String,String)
			for(Element ele:list){
				//获取ext的值,作为key
				String key=ele.attributeValue("ext");
				//获取type的值,作为value
				String value=ele.attributeValue("type");
				//存入map
				typeMap.put(key,value);
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		} 
	}
}
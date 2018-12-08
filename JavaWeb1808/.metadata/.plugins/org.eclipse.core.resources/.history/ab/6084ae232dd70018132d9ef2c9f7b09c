package cn.tedu.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 用来封装服务器相关的参数信息 
 * 1.创建ServletContext对象,读取xml的数据
 * 2.创建静态代码块完成封装
 */
public class ServletContext {
	//1.声明和web.xml对应的参数
	//参数的修饰符??public
	//为了方便调用如何修饰参数?? static
	//参数类型
	
	//端口号
	public static int port;
	
	//最大线程数
	public static int maxSize;
	
	//协议名和版本号
	public static String protocol;
	
	//webContent资源管理的根目录
	public static String webRoot;
	
	//声明一个notfound属性-->404
	public static String notFound;
	
	//存放content-type的值
	public static Map<String,String> typeMap=new HashMap<String,String>();
	
	//2.在静态代码块中完成赋值
	static{//创建static时,就会被加载,而且只加载一次
		init();
	}

	//xml解析
	//利用dom4j技术解析xml
	private static void init() {
		try {
			//SAXReader解析xml的工具类
			SAXReader reader=new SAXReader();
			
			//读取指定位置的文件
			Document doc=reader.read("config/web.xml");
			
			//解析xml中的元素,获取根元素server
			Element server=doc.getRootElement();
			
			//获取子元素service
			Element service=server.element("service");
			
			//获取孙子元素connector
			Element connector=service.element("connector");
			
			//获取port属性的值
			port=Integer.parseInt(connector.attributeValue("port"));//String--->int
			
			//获取maxSize属性的值并给成员变量赋值
			maxSize=Integer.parseInt(connector.attributeValue("maxSize"));
			
			//获取protocol属性的值,并给成员变量赋值
			protocol=connector.attributeValue("protocol");
			
			//获取webRoot标签的值并给成员变量赋值
			webRoot=service.elementText("webRoot");
			
			//为notfound属性标签赋值
			notFound=service.elementText("notfoundpage");
			
			//解析xml中的type-mappings的值
			List<Element> list=server.element("type-mappings").elements();
			//(String,String){获取ext的值,获取type的值}
			for(Element ele:list){
				//获取ext的值,作为key
				String key=ele.attributeValue("ext");
				String value=ele.attributeValue("type");
				//存入Map
				typeMap.put(key,value);
				
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}

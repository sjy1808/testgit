package cn.tedu.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 这个类用来封装http相关的参数
 * 1.声明常量
 * 2.把常量存入map
 *
 */
public class HttpContext {
	//1.声明常量(状态码,状态码的描述)
	public static final int CODE_OK=200;
	public static final int CODE_NOTFOUND=404;
	public static final int CODE_ERROR=500;
	
	//1.声明常量-状态码的描述
	public static final String DESC_OK="OK";
	public static final String DESC_NOTFOUND="NOTFOUND";
	public static final String DESC_ERROR="ERROR";
	
	//2.把常量存入map
	public static Map<Integer,String> descMap=new HashMap<Integer,String>();
	
	static {
		descMap.put(CODE_OK, DESC_OK);
		descMap.put(CODE_NOTFOUND, DESC_NOTFOUND);
		descMap.put(CODE_ERROR, DESC_ERROR);
		
	}
}

package util;

import redis.clients.jedis.Jedis;

public class TestRedis {

	public static void main(String[] args) {
		//设置连接服务器IP地址和访问端口
		Jedis jedis=new Jedis("192.168.80.134",7000);
		
		String s=jedis.get("name");
		System.out.println(s);
	}
}

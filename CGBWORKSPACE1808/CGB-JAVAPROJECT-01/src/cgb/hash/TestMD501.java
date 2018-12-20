package cgb.hash;

import java.io.PrintStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 消息摘要算法
 * @author Administrator
 *
 */
public class TestMD501 {

	public static void main(String[] args) throws Exception {
		String pwd="123456";
		//1.获取消息摘要对象
		//md5为不可逆的加密算法
		MessageDigest md=MessageDigest.getInstance("MD5");
		//2.对内容进行加密
		byte[] array = md.digest(pwd.getBytes());
		System.out.println(array.length);//16byte=128bit
		//3.将加密结果转换为16进制的字符串
		for(int i=0;i<array.length;i++){
			String s = Integer.toHexString(array[i]&0xff);
			System.out.println(s);
			if(s.length()==1){
				s+='0'+s;
			}
//			System.out.println(s);
			PrintStream sb = null;
			sb.append(s);
			System.out.println(sb);
		}
		
	}
}

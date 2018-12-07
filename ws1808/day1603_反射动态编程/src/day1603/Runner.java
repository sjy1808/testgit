package day1603;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;

public class Runner {
	public static void run() throws Exception{
		/*
		 * ������ṩһ������
		 * ���������·���ĸ�ʽ
		 * ����ȡ�ļ�������·��
		 * 
		 * "/"�����Ĵ��Ŀ¼
		 * 		����binĿ¼
		 * "/cfg.txt"-->D:\ws1808\day1603_���䶯̬���\bin\cfg.txt
		 * "/day1603/cfg.txt"
		 */
		String path=Runner.class.getResource("/cfg.txt").getPath();
		//URL�����ʽ-����->�ַ�
		path=URLDecoder.decode(path,"UTF-8");
		//System.out.println(path);
		BufferedReader in=new BufferedReader(new InputStreamReader(new FileInputStream(path)));
		String line;
		while((line=in.readLine())!=null){
			line =line.trim();
			if(line.length()==0) continue;
			
			run(line);//"day1603.A;a"
		}
		
		
	}
	private static void run(String line) throws Exception {
		String[] a=line.split(";");//���
		Class<?> c= Class.forName(a[0].trim());
		Object obj = c.newInstance();//�޲ι���
		//��÷���
		Method m = c.getMethod(a[1].trim());
		//ִ�з���
		m.invoke(obj);
	}
	/*public static void main(String[] args) throws Exception {
		Runner.run();
	}*/
}

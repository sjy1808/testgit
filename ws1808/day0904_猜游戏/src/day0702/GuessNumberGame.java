package day0702;

import java.util.Random;

public class GuessNumberGame extends GuessGame{

	@Override
	public String suiji() {
		int r=1+new Random().nextInt(1000);
		//int--->String
		return String.valueOf(r);//���������͵�����ת�����ַ���
	}

	@Override
	public void tiShi() {
		System.out.println("�Ѿ����������һ��[1,1001)��Χ������");
		System.out.println("�²�������Ǽ�");
	}

	@Override
	public String biJiao(String c, String r) {
		//String--->int
		int cc=Integer.parseInt(c);
		int rr=Integer.parseInt(r);
		if(cc>rr){
			return "��";
		}else if(cc<rr){
			return "С";
		}else{
			return "��";
		}
	}

	@Override
	public boolean caiDui(String result) {
		return "��".equals(result);
	}
	
}

package day0702;

import java.util.Random;

public class GuessNumberGame extends GuessGame{

	@Override
	public String suiji() {
		int r=1+new Random().nextInt(1000);
		//int--->String
		return String.valueOf(r);//把其他类型的数据转换成字符串
	}

	@Override
	public void tiShi() {
		System.out.println("已经随机产生了一个[1,1001)范围的整数");
		System.out.println("猜猜这个数是几");
	}

	@Override
	public String biJiao(String c, String r) {
		//String--->int
		int cc=Integer.parseInt(c);
		int rr=Integer.parseInt(r);
		if(cc>rr){
			return "大";
		}else if(cc<rr){
			return "小";
		}else{
			return "对";
		}
	}

	@Override
	public boolean caiDui(String result) {
		return "对".equals(result);
	}
	
}

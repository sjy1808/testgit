package day0702;

import java.util.Scanner;

public abstract class GuessGame {
	/*
	 * 相同代码：
	 * 猜数字和猜字母的游戏流程
	 */
	public void start(){
		//产生随机值
		String r=suiji();
		//提示
		tiShi();
		while(true){
			System.out.println("猜：");
			String c= new Scanner(System.in).nextLine();
			//比较c和r
			try {
				String result=biJiao(c,r);
				System.out.println(result);
				//判断是否是猜对的结果
				if(caiDui(result)){
					break;
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("输入有误，请重新尝试！");
				//e.printStackTrace();
			}
		}
	}

	public abstract String suiji();

	public abstract void tiShi();

	public abstract String biJiao(String c, String r);

	public abstract boolean caiDui(String result);
}

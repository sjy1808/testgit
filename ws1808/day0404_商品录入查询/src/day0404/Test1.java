package day0404;

import java.util.Scanner;

import javax.print.attribute.standard.RequestingUserName;

public class Test1 {
	//商品名称
	static String[] names={"小米","苹果","华为","三星","OPPL"};
	//商品价格
	static double[] prices={2045,5600,4012,4600,3056};
	//商品数量
	static int[] numbers={12,46,54,48,7};
	
	public static void main(String[] args) {
		outer:
		while(true){
			//显示菜单，并获得选择的选项值
			int c=menu();
			switch(c){
			case 1:f1();break;
			case 2:f2();break;
			case 3:f3();break;
			case 4:f4();break;
			case 5:break outer;
			default:
				System.out.println("选择错误");
			}
		}
		
	}

	private static int menu() {
		System.out.println("----------------");
		System.out.println("1.  商品列表");
		System.out.println("2.  商品录入");
		System.out.println("3.  商品查询");
		System.out.println("4.  统计信息");
		System.out.println("5.  退出");
		System.out.println("----------------");
		System.out.print("选择：");
		return new Scanner(System.in).nextInt();
		
	}

	private static void f1() {
		// 1. 名称：xxx， 价格：xxx, 数量：xxx
		//遍历数组
		for(int i=0;i<names.length;i++){
			String n=names[i];
			double p=prices[i];
			int b=numbers[i];
			System.out.println((i+1)+". 名称："+n+", 价格："+p+", 数量："+b);
		}
		
	}

	private static void f2() {
		// 遍历数组
		for(int i=0;i<names.length;i++){
			System.out.println("第"+(i+1)+"件商品：");
			System.out.print("名称：");
			names[i]=new Scanner(System.in).nextLine();
			System.out.print("价格：");
			prices[i]=new Scanner(System.in).nextDouble();
			System.out.print("数量：");
			numbers[i]=new Scanner(System.in).nextInt();
		}
		//重新显示商品列表
		f1();
		
	}

	private static void f3() {
		/*
		 *查询的商品的名称：xxx
		 * 1. 名称：xxx， 价格：xxx, 数量：xxx
		 * 找不到商品
		 */
		
		System.out.println("查询的商品名称：");
		String n=new Scanner(System.in).nextLine();
		//遍历数组
		for(int i=0;i<names.length;i++){
			//n与names[i]比较是否相等
			//字符串比较是否相等，要用equals()方法
			if(n.equals(names[i])){
				String a=names[i];
				double p=prices[i];
				int b=numbers[i];
				System.out.println((i+1)+". 名称："+a+", 价格："+p+", 数量："+b);
				//方法到此结束
				return;
			}
			
		}
		System.out.println("找不到商品");
		
	}

	private static void f4() {
		/*
		 * 商品总价
		 * 单价均价
		 * 最高单价
		 * 最高总价*/
		double spzj=0;
		double djzj=0;
		double zgdj=0;
		double zgzj=0;
		
		//遍历数组
		for(int i=0;i<names.length;i++){
			spzj+=prices[i]*numbers[i];
			djzj+=prices[i];
			//找比zgdj更大的值，存到zgdj变量
			if(prices[i]>zgdj){
				zgdj=prices[i];
			}
			if(prices[i]*numbers[i]>zgzj){
				zgzj=prices[i]*numbers[i];
			}
		}
		System.out.println("商品总价："+spzj);
		System.out.println("单价均价："+djzj/names.length);
		System.out.println("最高单价："+zgdj);
		System.out.println("最高总价："+zgzj);
		
	}
}

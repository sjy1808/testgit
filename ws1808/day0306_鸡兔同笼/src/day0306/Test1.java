package day0306;

public class Test1 {
	public static void main(String[] args) {
		//鸡(j)的数量从0到35，兔子(t)从35到0
		for(int j=0,t=35;j<=35;j++,t--){
			//j只鸡和t只兔子，脚的数量是否是94只
			if(j*2+t*4==94){
				System.out.println(j+"只鸡，"+t+"只兔");
			}
		}
	}
}

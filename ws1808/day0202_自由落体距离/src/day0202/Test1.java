package day0202;
import java.math.BigDecimal;
import java.util.Scanner;
public class Test1 {
	public static void main(String[] args) {
		System.out.print("输入降落时间（秒）：");
		//获得输入的值
		//再保存到变量t
		double t=new Scanner(System.in).nextDouble();
		//套公式，求自由落体距离
		//结果保存到d
		//double d=0.5*9.8*t*t;结果不精确
		BigDecimal bd1= BigDecimal.valueOf(4.9);
		BigDecimal bd2= BigDecimal.valueOf(t);
		
		double d=bd1.multiply(bd2)
					.multiply(bd2)
					.setScale(2,BigDecimal.ROUND_HALF_UP)
					.doubleValue();
		System.out.println(t+"秒降落了"+d+"米");
		
	}
}

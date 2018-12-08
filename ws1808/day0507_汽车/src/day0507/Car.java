package day0507;
/*
 * 封装
 * 		把汽车相关的属性数据，和运算方法代码，封装成一个类组件
 */
public class Car {
	String brand;//品牌。默认null
	String color;//颜色
	int speed;//速度，默认0
	
	public Car(String brand,String color,int speed){
		//有同名的局部变量
		//必须用this.xxx来访问成员变量
		this.brand=brand;
		this.color=color;
		this.speed=speed;
	}
	public void go(){
		System.out.println(color+brand+"前进，速度"+speed);
	}
	public void stop(){
		System.out.println(color+brand+"停止");
	}
}

package day0507;

public class Test1 {
	public static void main(String[] args) {
		//新建car对象，内存地址存到变量c1
		Car c1=new Car("保时捷","红色",350);
		Car c2=new Car("bmw","蓝色",250);
		//为c1对象的三个属性赋值
		/*c1.brand="保时捷";
		c1.color="红色";
		c1.speed=350;
		c2.brand="bmw";
		c2.color="蓝色";
		c2.speed=250;*/
		c1.go();
		c2.go();
		c1.stop();
		c2.stop();
	}
}

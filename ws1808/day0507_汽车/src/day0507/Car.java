package day0507;
/*
 * ��װ
 * 		��������ص��������ݣ������㷽�����룬��װ��һ�������
 */
public class Car {
	String brand;//Ʒ�ơ�Ĭ��null
	String color;//��ɫ
	int speed;//�ٶȣ�Ĭ��0
	
	public Car(String brand,String color,int speed){
		//��ͬ���ľֲ�����
		//������this.xxx�����ʳ�Ա����
		this.brand=brand;
		this.color=color;
		this.speed=speed;
	}
	public void go(){
		System.out.println(color+brand+"ǰ�����ٶ�"+speed);
	}
	public void stop(){
		System.out.println(color+brand+"ֹͣ");
	}
}

package day0507;

public class Test1 {
	public static void main(String[] args) {
		//�½�car�����ڴ��ַ�浽����c1
		Car c1=new Car("��ʱ��","��ɫ",350);
		Car c2=new Car("bmw","��ɫ",250);
		//Ϊc1������������Ը�ֵ
		/*c1.brand="��ʱ��";
		c1.color="��ɫ";
		c1.speed=350;
		c2.brand="bmw";
		c2.color="��ɫ";
		c2.speed=250;*/
		c1.go();
		c2.go();
		c1.stop();
		c2.stop();
	}
}

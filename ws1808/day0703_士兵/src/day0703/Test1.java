package day0703;

public class Test1 {
	public static void main(String[] args) {
		//�½�ʿ�������ڴ��ַ���浽����s1
		Soldier s1=new Soldier();
		Soldier s2=new Soldier();
		
		//��s1,���õ�������ڴ�ռ䣬��������id����
		s1.id=9527;
		s2.id=9528;
		
		//��s1���õ�һ��ʿ�����󣬿�����ִ��go()��������
		s1.go();
		s2.go();
		s2.attack();
		s2.attack();
		s2.attack();
		s2.attack();
		s2.attack();
		s2.attack();
		s2.attack();
		s2.attack();
		s2.attack();
		s2.attack();
		
	}
}

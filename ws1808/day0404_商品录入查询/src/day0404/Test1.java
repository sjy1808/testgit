package day0404;

import java.util.Scanner;

import javax.print.attribute.standard.RequestingUserName;

public class Test1 {
	//��Ʒ����
	static String[] names={"С��","ƻ��","��Ϊ","����","OPPL"};
	//��Ʒ�۸�
	static double[] prices={2045,5600,4012,4600,3056};
	//��Ʒ����
	static int[] numbers={12,46,54,48,7};
	
	public static void main(String[] args) {
		outer:
		while(true){
			//��ʾ�˵��������ѡ���ѡ��ֵ
			int c=menu();
			switch(c){
			case 1:f1();break;
			case 2:f2();break;
			case 3:f3();break;
			case 4:f4();break;
			case 5:break outer;
			default:
				System.out.println("ѡ�����");
			}
		}
		
	}

	private static int menu() {
		System.out.println("----------------");
		System.out.println("1.  ��Ʒ�б�");
		System.out.println("2.  ��Ʒ¼��");
		System.out.println("3.  ��Ʒ��ѯ");
		System.out.println("4.  ͳ����Ϣ");
		System.out.println("5.  �˳�");
		System.out.println("----------------");
		System.out.print("ѡ��");
		return new Scanner(System.in).nextInt();
		
	}

	private static void f1() {
		// 1. ���ƣ�xxx�� �۸�xxx, ������xxx
		//��������
		for(int i=0;i<names.length;i++){
			String n=names[i];
			double p=prices[i];
			int b=numbers[i];
			System.out.println((i+1)+". ���ƣ�"+n+", �۸�"+p+", ������"+b);
		}
		
	}

	private static void f2() {
		// ��������
		for(int i=0;i<names.length;i++){
			System.out.println("��"+(i+1)+"����Ʒ��");
			System.out.print("���ƣ�");
			names[i]=new Scanner(System.in).nextLine();
			System.out.print("�۸�");
			prices[i]=new Scanner(System.in).nextDouble();
			System.out.print("������");
			numbers[i]=new Scanner(System.in).nextInt();
		}
		//������ʾ��Ʒ�б�
		f1();
		
	}

	private static void f3() {
		/*
		 *��ѯ����Ʒ�����ƣ�xxx
		 * 1. ���ƣ�xxx�� �۸�xxx, ������xxx
		 * �Ҳ�����Ʒ
		 */
		
		System.out.println("��ѯ����Ʒ���ƣ�");
		String n=new Scanner(System.in).nextLine();
		//��������
		for(int i=0;i<names.length;i++){
			//n��names[i]�Ƚ��Ƿ����
			//�ַ����Ƚ��Ƿ���ȣ�Ҫ��equals()����
			if(n.equals(names[i])){
				String a=names[i];
				double p=prices[i];
				int b=numbers[i];
				System.out.println((i+1)+". ���ƣ�"+a+", �۸�"+p+", ������"+b);
				//�������˽���
				return;
			}
			
		}
		System.out.println("�Ҳ�����Ʒ");
		
	}

	private static void f4() {
		/*
		 * ��Ʒ�ܼ�
		 * ���۾���
		 * ��ߵ���
		 * ����ܼ�*/
		double spzj=0;
		double djzj=0;
		double zgdj=0;
		double zgzj=0;
		
		//��������
		for(int i=0;i<names.length;i++){
			spzj+=prices[i]*numbers[i];
			djzj+=prices[i];
			//�ұ�zgdj�����ֵ���浽zgdj����
			if(prices[i]>zgdj){
				zgdj=prices[i];
			}
			if(prices[i]*numbers[i]>zgzj){
				zgzj=prices[i]*numbers[i];
			}
		}
		System.out.println("��Ʒ�ܼۣ�"+spzj);
		System.out.println("���۾��ۣ�"+djzj/names.length);
		System.out.println("��ߵ��ۣ�"+zgdj);
		System.out.println("����ܼۣ�"+zgzj);
		
	}
}

package day0702;

import java.util.Scanner;

public abstract class GuessGame {
	/*
	 * ��ͬ���룺
	 * �����ֺͲ���ĸ����Ϸ����
	 */
	public void start(){
		//�������ֵ
		String r=suiji();
		//��ʾ
		tiShi();
		while(true){
			System.out.println("�£�");
			String c= new Scanner(System.in).nextLine();
			//�Ƚ�c��r
			try {
				String result=biJiao(c,r);
				System.out.println(result);
				//�ж��Ƿ��ǲ¶ԵĽ��
				if(caiDui(result)){
					break;
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("�������������³��ԣ�");
				//e.printStackTrace();
			}
		}
	}

	public abstract String suiji();

	public abstract void tiShi();

	public abstract String biJiao(String c, String r);

	public abstract boolean caiDui(String result);
}

package day1403;

public class Test1 {
	public static void main(String[] args) {
		T1 t1 = new T1();
		T1 t2 = new T1();
		
		//��start()���������߳�
		//�߳������󣬻��Զ�ִ����()��������
		t1.start();
		t2.start();
		System.out.println("main�߳�");
	}

	static class T1 extends Thread {
		// ��̬�����ͨ��û��ʲô����
		// Ƕ�׶��� �� ��ϵ�Ƚ����У�Ҳ�����½�һ����
		@Override
		public void run() {
			// ����߳���
			String n = getName();
			for (int i = 1; i <= 5; i++) {
				System.out.println(n + ":" + i);
			}
		}

	}
}

package day0804;

public class Test2 {
	public static void main(String[] args) {
		Weapon w1 = f1();
		w1.kill();
		System.out.println(w1);

		Weapon w2 = f2("�������µ�");
		w2.kill();
		System.out.println(w2);
	}

	private static Weapon f2(final String name) {
		Weapon w = new Weapon() {// ��     ʡ��class������      �����ࣺnew{}   Weapon����
			@Override
			public void kill() {
				System.out.println("ʹ��" + name + "����");
			}
		};
		return w;
	}

	private static Weapon f1() {
		// ����ֲ��ڲ���
		class Ak47 implements Weapon {
			@Override
			public void kill() {
				// TODO Auto-generated method stub
				System.out.println("ʹ��AK47����");
			}
		}
		Ak47 a = new Ak47();
		return a;// ���������ʹ���ȥ
	}
}

package day0804_private;

public class Test2 {
	public static void main(String[] args) {
		Weapon w1 = f1();
		w1.kill();
		System.out.println(w1);

		Weapon w2 = f2("青龙偃月刀");
		w2.kill();
		System.out.println(w2);
	}

	private static Weapon f1() {
		// 定义局部内部类
		class AK47 implements Weapon {

			@Override
			public void kill() {
				// TODO Auto-generated method stub
				System.out.println("使用AK47进攻");
			}

		}
		AK47 a = new AK47();
		return a;
	}

	private static Weapon f2(final String name) {
		Weapon w = new Weapon() {

			@Override
			public void kill() {
				// TODO Auto-generated method stub
				System.out.println("使用" + name + "进攻");
			}

		};
		return w;
	}
}

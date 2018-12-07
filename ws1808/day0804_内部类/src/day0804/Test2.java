package day0804;

public class Test2 {
	public static void main(String[] args) {
		Weapon w1 = f1();
		w1.kill();
		System.out.println(w1);

		Weapon w2 = f2("青龙偃月刀");
		w2.kill();
		System.out.println(w2);
	}

	private static Weapon f2(final String name) {
		Weapon w = new Weapon() {// 类     省略class和类名      匿名类：new{}   Weapon父类
			@Override
			public void kill() {
				System.out.println("使用" + name + "进攻");
			}
		};
		return w;
	}

	private static Weapon f1() {
		// 定义局部内部类
		class Ak47 implements Weapon {
			@Override
			public void kill() {
				// TODO Auto-generated method stub
				System.out.println("使用AK47进攻");
			}
		}
		Ak47 a = new Ak47();
		return a;// 当做父类型传出去
	}
}

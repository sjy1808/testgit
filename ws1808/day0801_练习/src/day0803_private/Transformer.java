package day0803_private;

public class Transformer {
	private Weapon w;

	public void setWeapon(Weapon w) {
		this.w = w;
	}

	public void attack() {
		if (w == null) {
			System.out.println("使用拳头");
			return;
		}
		String type = "";
		switch (w.getType()) {
		case Weapon.TYPE_CLOD:
			type = "冷兵器";
			break;
		case Weapon.TYPE_HOT:
			type = "热兵器";
			break;
		case Weapon.TYPE_NUCLEAR:
			type = "核武器";
			break;
		}
		System.out.println("使用" + type + w.getName() + "进攻");
		w.kill();
	}

}

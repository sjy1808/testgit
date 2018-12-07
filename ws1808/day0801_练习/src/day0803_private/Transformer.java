package day0803_private;

public class Transformer {
	private Weapon w;

	public void setWeapon(Weapon w) {
		this.w = w;
	}

	public void attack() {
		if (w == null) {
			System.out.println("ʹ��ȭͷ");
			return;
		}
		String type = "";
		switch (w.getType()) {
		case Weapon.TYPE_CLOD:
			type = "�����";
			break;
		case Weapon.TYPE_HOT:
			type = "�ȱ���";
			break;
		case Weapon.TYPE_NUCLEAR:
			type = "������";
			break;
		}
		System.out.println("ʹ��" + type + w.getName() + "����");
		w.kill();
	}

}

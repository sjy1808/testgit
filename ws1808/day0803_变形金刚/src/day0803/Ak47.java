package day0803;

public class Ak47 implements Weapon{

	@Override
	public void kill() {
		// TODO Auto-generated method stub
		System.out.println("ˣǹ");
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "AK47";
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return Weapon.TYPE_HOT;
	}

}

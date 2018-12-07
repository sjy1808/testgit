package day0803;

public class Sword implements Weapon{

	@Override
	public void kill() {
		// TODO Auto-generated method stub
		System.out.println("Ë£½£");
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "ÒÐÌì½£";
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return Weapon.TYPE_COLD;
	}

}

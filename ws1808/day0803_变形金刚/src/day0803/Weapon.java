package day0803;

public interface Weapon {
	/*public static final缺省存在  公开的常量*/
	int TYPE_COLD=747;
	int TYPE_HOT=757;
	int TYPE_NUCLEAR=777;
	/*public abstract缺省存在*/
	//抽象方法
	void kill();

	String getName();

	int getType();
}

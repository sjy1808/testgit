package day0803;

public interface Weapon {
	/*public static finalȱʡ����  �����ĳ���*/
	int TYPE_COLD=747;
	int TYPE_HOT=757;
	int TYPE_NUCLEAR=777;
	/*public abstractȱʡ����*/
	//���󷽷�
	void kill();

	String getName();

	int getType();
}

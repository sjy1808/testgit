package day0803;

public class Transformer {
	//���ν��ʹ�������ӿڣ������ӿ���Ϊ��Ա��������
	private Weapon w;//null
	public void setWeapon(Weapon w){
		this.w=w;
	}
	public void attack(){
		if(w==null){
			System.out.println("����ҧ");
			return;
		}
		/*
		 * ��������ת��������ַ���
		 */
		String type="";
		switch(w.getType()){
		case Weapon.TYPE_COLD:type="�����";break;
		case Weapon.TYPE_HOT:type="�ȱ���";break;
		case Weapon.TYPE_NUCLEAR:type="������";break;
		}
		//ʹ����������콣����
		System.out.println("ʹ��"+type+w.getName()+"����");
		w.kill();
	}
}

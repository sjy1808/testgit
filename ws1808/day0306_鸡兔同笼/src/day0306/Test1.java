package day0306;

public class Test1 {
	public static void main(String[] args) {
		//��(j)��������0��35������(t)��35��0
		for(int j=0,t=35;j<=35;j++,t--){
			//jֻ����tֻ���ӣ��ŵ������Ƿ���94ֻ
			if(j*2+t*4==94){
				System.out.println(j+"ֻ����"+t+"ֻ��");
			}
		}
	}
}

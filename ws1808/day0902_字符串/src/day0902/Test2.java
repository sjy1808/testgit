package day0902;

public class Test2 {
	public static void main(String[] args) {
		String s0 = "abcdefghijklmnopqrstuvwxyz";
		String s = "";

		// ȡϵͳ��ǰʱ���ʱ��㣬����ֵ
		// ����ֵ����1970-1-1 0�㿪ʼ�ĺ���ֵ
		long t = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			s += s0;
		}
		t = System.currentTimeMillis() - t;
		System.out.println(t);
	}
}

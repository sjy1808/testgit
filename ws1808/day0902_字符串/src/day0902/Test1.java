package day0902;

public class Test1 {
	public static void main(String[] args) {
		// 1.�½����� 2.�½�String�����װ����
		char[] a = { 'a', 'b', 'c' };
		String s1 = new String(a);//���ڴ��·����ڴ�ռ�
		String s2 = "abc";//�������·����ڴ�ռ�
		String s3 = "abc";//���ʳ����ش��ڵĶ���

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s1 == s2);//�Ƚ��ڴ��ַ
		System.out.println(s2 == s3);
		System.out.println(s1.equals(s2));//�Ƚ��ַ�����
	}
}

package day0502;

public class Test1 {
	public static void main(String[] args) {
		char[][] a={
				{'μ','��','��','��','��','��','��'},
				{'��','��','��','��','��','ɫ','��'},
				{'Ȱ','��','��','��','һ','��','��'},
				{'��','��','��','��','��','��','��'},
		};
		/* a.length-1
		 * 3 2 1 0 j
		 *i 
		 *0��Ȱ��μ
		 *1 �������
		 *2 �����೯
		 *3 ��..
		 *a[0].length
		 */
		for(int i=0;i<a[0].length;i++){
			for(int j=a.length-1;j>=0;j--){
				System.out.print(a[j][i]);
			}
			System.out.println();
		}
	}
}

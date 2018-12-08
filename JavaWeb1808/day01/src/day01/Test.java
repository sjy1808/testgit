package day01;

public class Test {
	public static void main(String[] args) {
		System.out.println("abcd".lastIndexOf("bc",1));
		String String="String";
		char[][] a={
				{'渭','城','朝','雨','浥','轻','尘'},

	            {'客','舍','青','青','柳','色','新'},

	            {'劝','君','更','尽','一','杯','酒'},

	            {'西','出','阳','关','无','故','人'}
		};
		for(int j=0;j<a[0].length;j++){
			for(int i=a.length-1;i>=0;i--){
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
}

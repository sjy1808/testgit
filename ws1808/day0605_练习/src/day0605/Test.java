package day0605;

public class Test {
	public static void main(String[] args) {
		int n=0;
		for(int i=1;i<=9;i++){
			for(int j=1;j<=i;j++){
				n=i*j;
				System.out.print(j+"*"+i+"="+n+"\t");
			}
			System.out.println("");
		}
	}
}

package homework;

public class Day0301 {
	public static void main(String[] args) {
		for(int i=1;i<=9;i++){
			for(int j=1;j<=i;j++){
				int n=i*j;
				System.out.print(j+"*"+i+"="+n+"\t");
			}
			System.out.println();
		}
	}
}

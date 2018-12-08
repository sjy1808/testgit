package homework;

import java.util.Arrays;
import java.util.Random;

public class Day0501 {
	public static void main(String[] args) {
		int[] a=suiji();
		int[] b=suiji();
		Arrays.sort(a);
		Arrays.sort(b);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		int[] c=hebing(a,b);
		System.out.println(Arrays.toString(c));
	}

	private static int[] suiji() {
		int n=5+new Random().nextInt(6);
		int[] a=new int[n];
		for(int i=0;i<a.length;i++){
			a[i]=new Random().nextInt(100);
		}
		return a;
	}

	private static int[] hebing(int[] a, int[] b) {
		int[] c=new int[a.length+b.length];
		for(int i=0,j=0,k=0;i<c.length;i++){
			if(j>=a.length){
				System.arraycopy(b, k, c, i, b.length-k);
				break;
			}
			if(k>=b.length){
				System.arraycopy(a, j, c, i, a.length-j);
				break;
			}
			if(a[j]>a[k]){
				c[i]=a[k];
				k++;
			}else{
				c[i]=a[j];
				j++;
			}
			
		}
		return c;
	}
}

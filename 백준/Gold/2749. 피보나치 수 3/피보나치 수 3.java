import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//N번째
		long N = sc.nextLong();
		
		//주기
		int P = 1_500_000;
		
		//나눌 값
		int M = 1_000_000;		
		
		//N%P번째 피보나치 수
		int remainder = (int)(N % P);
		
		if(remainder == 0) {
			System.out.println(0);
			return;
		}
		
		//int 배열
		long[] arr = new long[remainder+1];
		
		arr[0] = 0;
		arr[1] = 1;
		
		for(int i = 2; i<=remainder; i++) {
			arr[i] = (arr[i-2] + arr[i-1])%M;
		}
//		System.out.println(remainder);
//		System.out.println(Arrays.toString(arr));
		
		System.out.println(arr[remainder]);
	}	
}


/* 백준 1463 1로 만들기
[문제 이해]
- 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지이다.

1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
2. X가 2로 나누어 떨어지면, 2로 나눈다
3. 1을 뺀다.

 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
*/
//import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int X = sc.nextInt();
		
		//X까지 도달하기까지의 값들을 저장해서 꺼낼 수 있는 배열
		int[] xArr = new int[X+1];
		
		for(int i = 2; i<=X; i++) {
			
			int a = Integer.MAX_VALUE;
			int b = Integer.MAX_VALUE;
			int c = Integer.MAX_VALUE;
			
			//3을 나눴을 때
			if(i % 3 == 0) {
				int temp = i/3;
				a = xArr[temp] + 1;
			}
			
			//2를 나눴을 때
			if(i % 2 == 0) {
				int temp = i/2;
				b = xArr[temp] + 1;
			}
			
			//1을 뺐을 때
		
			int temp = i-1;
			c = xArr[temp] + 1;
			
			
			xArr[i] = Math.min(a, Math.min(b, c));
		}
//		System.out.println(Arrays.toString(xArr));
		
		System.out.println(xArr[X]);
	}
	
	
}

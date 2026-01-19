import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	/*문제
	 * 숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 
	 * 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 가지고 있는지 아닌지를 구하는 프로그램을 작성하시오.
	 * */

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//상근이가 가지고 있는 숫자의 개수
		int N = sc.nextInt();
		
		//상근이가 가지고 있는 카드
		int[] cardList = new int[N];
		
		for(int i = 0; i<N; i++) {
			cardList[i] = sc.nextInt();
		}
		
		Arrays.sort(cardList);

		//상근이가 가지고 있는 카드가 맞는지 아닌지의 개수
		int M = sc.nextInt();
		
		//정답 배열
		int[] resultArr = new int[M];
		
		//상근이 카드와 비교
		int[] list = new int[M];
		
		for(int i = 0; i<M; i++) {
			list[i] = sc.nextInt();
		}
		
		//비교
		for(int i = 0; i<M ; i++) {
			int result = Arrays.binarySearch(cardList, list[i]);
			
			if(result >= 0) {
				System.out.print(1 + " ");
				continue;
			}else {
				System.out.print(0 + " ");
			}
		}
		
		
	}
}
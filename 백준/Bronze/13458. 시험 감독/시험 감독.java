/* 시험감독
[문제 상황]
N개의 시험장이 있고, 각각의 시험장마다 응시자들이 있다
i번 시험장에 있는 응시자의 수는 Ai명

감독관은 총감독관, 부감독관 두 종류가 있다
총감독관은 한 시험장에서 감시할 수 있는 응시자의 수가 B명
부감독관은 한 시험장에서 감시할 수 있는 응시자의 수가 C명

각각의 시험장에 총감독관은 오직 1명, 부감독관은 여러명 가능
모든 응시생들을 감시해야 될 때 필요한 감독관의 최솟값
 
[로직생각]
해당 시험장의 응시장을 1차원 배열로 담아둔 다음
해당 시험장의 응시자 수에 총감독관이 볼수 있는 인원을 먼저 빼고, 그다음 남은 값에
부감독관이 볼 수 있는 인원을 나누고 나머지가 있으면 1을 더해준다
*/

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 시험장
		int N = sc.nextInt();

		// 시험장 배열
		int intArr[] = new int[N];

		//총 필요한 감독관
		//N을 넣은 이유는 어차피 한 시험장에 총 감독관 1명은 무조건 필요
		long result = N;
		
		for (int i = 0; i < N; i++) {
			intArr[i] = sc.nextInt();
		}
		
		// 총 감독관이 볼 수 있는 인원
		int B = sc.nextInt();

		// 부 감독관이 볼 수 있는 인원
		int C = sc.nextInt();

		for (int i = 0; i < N; i++) {
			int temp = intArr[i] - B;
			if(temp <= 0) continue;
			int temp2 = temp / C;
			result += temp2;
			if(temp > temp2*C) result++;
		}
		
		System.out.println(result);
	}
}

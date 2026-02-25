/* 백준 섬의개수
[문제 이해]
- 정사각형으로 이루어져 있는 섬과 바다 지도가 주어진다. 섬의 개수를 세는 프로그램을 작성
- 한 정사각형과 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 걸아갈 수 있는 사각형이다.

- 두 정사각형이 같은 섬에 있으러면, 한 정사각형에서 다른 정사각형으로 걸어갈 수 있는 경로가 있어야 한다. 
  지도는 바다로 둘러싸여 있으며 지도 밖으로 나갈 수 없다.
*/

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	// 상우하좌 대각선
	static int[] dx = { -1, 0, 1, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 1, 0, -1, 1, -1, 1, -1 };

	// 섬 배치
	static int[][] board;

	// 행, 열
	static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 섬의 개수 총 개수
		int result = 0;

		while (true) {
			M = sc.nextInt();
			N = sc.nextInt();

			// 섬 배치
			board = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					board[i][j] = sc.nextInt();
				}
			}

			// N과 M이 0이면 멈춘다
			if (N == 0 && M == 0)
				break;

			result = 0;


			// 섬찾기 시작
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// 만약 내가 도달한 곳이 섬이면 시작
					if (board[i][j] == 1) {
//						System.out.println(i + ", " + j);
						game(i, j);
						result++;
//						for(int[] b : board) {
//							System.out.println(Arrays.toString(b));
//						}
//						System.out.println("----------------");

					}
				}
			}

			System.out.println(result);
		}
	}

	static void game(int col, int row) {

		// 만약에 맵 밖이거나 0(바다)면 멈추기
		if (col < 0 || col >= N || row < 0 || row >= M || board[col][row] == 0)
			return;

//		System.out.println("col : " + col);
//		System.out.println("row : " + row);

		// 아니면 이어진 섬이기 때문에 해당 장소 0으로 만들어버리기
		board[col][row] = 0;

//		for (int[] b : board) {
//			System.out.println(Arrays.toString(b));
//		}
//		System.out.println("----------------");

		// 아니면 탐색 시작
		for (int i = 0; i < 8; i++) {
			int mx = col + dx[i];
			int my = row + dy[i];

			game(mx, my);
		}
	}

}

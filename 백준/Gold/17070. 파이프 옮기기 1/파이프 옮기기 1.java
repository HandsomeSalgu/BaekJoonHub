/*  백준 17070 파이프 옮기기1
- 파이프는 2개의 연속된 칸을 차지하는 크기
- 파이프는 회전 시킬 수 있다 →, ↘, ↓

-파이프는 무거워서 밀어서 이동시키고 싶지만, 벽에는 새로운 벽지를 발랐기 때문에 파이프가 벽을 글으면 안된다.
- 즉 파이프는 항상 빈 칸만 차지해야 한다.
- 회전은 45도만 가능

- 가장 처음에 파이프는 (1,1)와 (1,2)를 차지, 방향은 가로, 파이프의 한쪽 끝을 (N,N)로 이동시키는 방법의 개수
*/

import java.util.Deque;
import java.util.Scanner;

public class Main {

	// 총 움직일 수 있는 카운팅
	static int count;

	// 집의 크기
	static int N;

	// 파이프 보드
	static int[][] board;

	// →, ↘, ↓
	static int[] dx = { 0, 1, 1 };
	static int[] dy = { 1, 1, 0 };


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 집의 크기
		N = sc.nextInt();

		// 파이프 배치
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
			}
		}
			
		// 게임 시작
		// 파이프의 마지막 위치에서 부터 시작해야되니깐 여기서부터 시작
		game(0, 1, 0);
		
		System.out.println(count);
	}

	static void game(int x, int y, int angle) {

		// 보드에서 나가면 멈추기
		if (x < 0 || y < 0 || x >= N || y >= N)
			return;
		
		// 가로 혹은 세로 앞에 벽이 있으면 멈추기
		if (board[x][y] == 1)
			return;
		
		//대각선 같은 경우 해당 인덱스 위 아래까지 확인
		if (angle == 1 && (board[x-1][y] == 1 || board[x][y-1] == 1))
			return;
		
		// 마지막에 도달하면 멈추기
		if (x == N - 1 && y == N - 1) {
			count++;
			return;
		}

		int mx = 0;
		int my = 0;
		
		//자 그러면 이제 출발
		if(angle == 0) {
			for(int i = 0; i < 2; i++) {
				mx = x + dx[i];
				my = y + dy[i];
				angle = i;
				game(mx,my,angle);
			}
		}
		else if(angle == 1){
			for(int i = 0; i < 3; i++) {
				mx = x + dx[i];
				my = y + dy[i];
				angle = i;
				game(mx,my,angle);
			}
		}else {
			for(int i = 1; i < 3; i++) {
				mx = x + dx[i];
				my = y + dy[i];
				angle = i;
				game(mx,my,angle);
			}
		}
	}
}
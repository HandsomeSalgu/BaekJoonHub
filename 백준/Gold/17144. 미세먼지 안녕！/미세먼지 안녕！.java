/* 백준 17144_미세먼지야 안녕~~
[문제 이해]
- 공기 청정기는 항상 1번 열에 설치되어 있음(크기는 두 행을 차지)
- 공기청정기가 설치되어 있지 않은 칸에는 미세먼지가 있음 (r,c)에 있는 미세먼지의 양은 A(r,c))

- 1초동안 일어나는 일들
1. 미세먼지가 확산된다, 확산은 미세먼지가 있는 모든 칸에 동시에 일어남
	- (r,c)에 있는 미세먼지는 인접한 네 방향으로 확산
	- 인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 안일어남
	- 확산되는 양은 A(r,c)/5이고 소수점은 버린다
	- (r,c)에 남은 미세먼지의 양은 A(r,c) - (A(r,c)/5) * 확산된 방향의 개수

2.  공기청정기가 작동한다
	- 공기 청정기에서는 바람이 나온다
	- 위쪽 공기 청정기의 바람은 반시계방향으로 순환, 아래쪽 공기청정기의 바람은 시계방향으로 순환
	- 바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸 씩이동
	- 공기청정기에서 부는 바람은 미세먼지가 없는 바람이고, 공기청정기로 들어간 미세먼지는 모두 정화
*/

import java.util.Scanner;

public class Main {

	// 상우하좌
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 행과 열
		int r = sc.nextInt();
		int l = sc.nextInt();
		

		// T초 후 미세먼지의 양
		int T = sc.nextInt();

		// 보드 주어짐
		int[][] board = new int[r][l];


		// 공기청정기 위치, 0이 상, 1이 하
		int[] airCleanerLoc = new int[2];

		// 보드에 넣기
		int idx = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < l; j++) {
				int temp = sc.nextInt();
				board[i][j] = temp;
				if (temp == -1) {
					airCleanerLoc[idx] = i;
					idx++;
				}
			}
		}

		// T번 반복
		for (int TC = 0; TC < T; TC++) {
			
			// 미세먼지 확산이 일어나고, 모든 위치의 값을 더할 때 사용하는 배열
			int[][] airEnd = new int[r][l];


			// 미세먼지 확산
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < l; j++) {
					// 만약 해당 위치가 0이면 넘어가기
					if (board[i][j] == 0)
						continue;

					// 확산된 곳 카운팅
					int count = 0;

					// 기존 미세먼지
					int curNum = board[i][j];

					// 확산된 미세먼지
					int airNum = curNum / 5;

					// 아니면 확산 시작
					for (int k = 0; k < 4; k++) {
						int mx = i + dx[k];
						int my = j + dy[k];

						// 만약 해당 확산되는 위치가 보드 밖이거나, 공기청정기면 멈춰야함
						if (mx < 0 || my < 0 || mx >= r || my >= l || board[mx][my] == -1)
							continue;

						// airEnd에 더해놓고 나중에 한 번에 더하기
						airEnd[mx][my] += airNum;
						count++;
					}

					board[i][j] = curNum - airNum * count;
				}
			}
			

			// 확산됐으니 해당 확산된 거 다시 다 더해주기
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < l; j++) {
					board[i][j] += airEnd[i][j];
				}
			}

			// 이제 공기 청정기 순환하기
			// 배열에 넣어둔 거 순서대로 할 거임 0은 위쪽이니 시계방향, 1은 아래쪽이니 반시계방향
			for (int i = 0; i < 2; i++) {
				// 현재 배열의 x 좌표
				// i가 0이면 상, 상은 반시계방향
				if (i == 0) {
					int curX = airCleanerLoc[i];
					int curY = 0;
				
					// ↓
					//curX가 0이면 위에서 끌고 올게 없음
					while(curX > 0) {	
						int temp = board[curX-1][curY];
						if(board[curX][curY] != -1)
							board[curX][curY] = temp;
						curX--;
					}
					

					// ←
					curX = 0;
					while(curY < l-1) {
						int temp = board[curX][curY+1];
						if(board[curX][curY] != -1)
							board[curX][curY] = temp;
						curY++;
					}
					

					// ↑
					curY = l-1;
					while(curX < airCleanerLoc[i]) {
						
						int temp = board[curX +1][curY];
						board[curX][curY]= temp;
						curX++;
					}
				
					// →
					curX = airCleanerLoc[i];
					while(curY > 1) {
						int temp = board[curX][curY-1];
						
						board[curX][curY]= temp;
						curY--;
					}
					
					board[airCleanerLoc[i]][1] = 0;

				} else {
					int curX = airCleanerLoc[i];
					int curY = 0;

					// ↑
					curX++;
					while(curX < r-1) {
						int temp = board[curX +1][curY];
						board[curX][curY]= temp;
						curX++;
					}

					// ←
					curX = r-1;
					while(curY < l-1) {
						int temp = board[curX][curY+1];
						if(board[curX][curY] != -1)
							board[curX][curY] = temp;
						curY++;
					}
					
					// ↓
					curY = l-1;
					while(curX > airCleanerLoc[i]) {	
						int temp = board[curX-1][curY];
						if(board[curX][curY] != -1)
							board[curX][curY] = temp;
						curX--;
					}
					// →
					curX = airCleanerLoc[i];
					while(curY > 1) {
						
						int temp = board[curX][curY-1];
						board[curX][curY]= temp;
						curY--;
	
					}
					
					board[airCleanerLoc[i]][1] = 0;
				}
			}

		}
		
		//끝났으면 전체 더해주기
		int result = 0;
		for(int i = 0; i<r; i++) {
			for(int j = 0; j<l;j++) {
				if(board[i][j] != -1) {
					result += board[i][j];
				}
//				System.out.print(board[i][j] + " ");
			}
//			System.out.println();
		}
		System.out.println(result);
	}
}

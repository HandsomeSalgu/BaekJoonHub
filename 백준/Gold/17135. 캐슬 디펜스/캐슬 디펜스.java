import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.StringTokenizer;

/* 백준 17135번_캐슬디펜스
[문제상황]
- 성을 향해 몰려오는 적을 잡는 턴 방식의 게임
- 게임이 진행되는 곳은 크기가 N*M 격자판으로 나타낼 수 있다
- 격자판은 1*1 크기의 칸으로 나누어져있다
- 각 칸에 포함된 적의 수는 최대 하나이다.

- 성을 적에게서 지키기 위해 궁수 3명을 배치
- 궁수는 성이 있는 칸에 배치, 하나의 칸에는 최대 1명의 궁수만 있다
- 각각의 턴마다 궁수는 적 하나를 공격할 수 있다.
- 모든 궁수는 동시에 공격한다.
- 궁수가 공격하는 적은 거리가 D이하인 적 중 가장 가까운 적
- 그러한 적이 여럿일 경우 가장 왼쪽에 있는 적을 공격
- 같은 적이 여러 궁수에게 공격당할 수 있음
- 공격받은 적은 게임에서 제외

-궁수의 공격이 끝나면 적이 이동
-적은 아래로 한 칸 이동하며, 성이 있는 칸으로 이동하는 경우 게임에서 제외
- 모든 적이 격자판에서 제외되면 게임이 끝남

- 궁수를 배치한 이후의 게임 진행은 정해져있다.
- 궁수의 공격으로 제거할 수 있는 적의 최대 수

[로직 생각]
- N+1에 성이 있으며 적들이 내려온다
- 궁수의 위치는 바꿀 수 없다
- 궁수가 죽일 수 있는 범위에 따라 애들을 죽이는 로직 작성
    - 궁수가 위치를 바꿀 수 없으니 bfs를 사용해서 궁수의 위치마다 애들을 죽일 수 있는 최대 수를 구해보자
    - 만약에 적을 다 죽였다고 판단되면 바로 반복문 종료 후 최대수 구하기

- 적을 죽일 때 우선 순위
 1. 궁수의 공격범위 안에서 성과 거리가 제일 가까운 적들 처리
*/

public class Main {

	static class Node {
		// 현재 위치
		int x;
		int y;

		// 움직인 거리
		int moveCount;

		Node() {
		}

		Node(int x, int y, int moveCount) {
			this.x = x;
			this.y = y;
		}
	}

	// 격자판 행 N, 열 M
	static int N, M;

	// 궁수의 공격 거리 제한
	static int D;

	// 보드판
	static int[][] board;

	// 궁수의 위치(논리형 배열)
	static boolean[] archerArr;

	// 적의 총 수
	static int enemyCount;

	// 정답
	static int result;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 격자판 행의 수와 열의 수
		N = sc.nextInt();
		M = sc.nextInt();

		// 궁수의 공격 거리 제한
		D = sc.nextInt();
		sc.nextLine();

		// 보드판을 담을 수 있는 2차원 배열 만들고 적 넣기
		board = new int[N][M];

		// 궁수 위치 1차원 배열 만들기
		archerArr = new boolean[M];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
			int idx = 0;
			while (st.hasMoreTokens()) {
				int temp = Integer.parseInt(st.nextToken());
				board[i][idx++] = temp;
				// 적이 총 몇명인가 확인
				if (temp == 1)
					enemyCount++;
			}
		}

		// 게임 시작
		archerArr(0, 0);

		System.out.println(result);
	}

	static void archerArr(int idx, int start) {

		// 만약 result가 최대 적의 수면 게임을 끝냄
		if (result == enemyCount)
			return;

		// 궁수가 3명 배치되면 배치 끝내고 게임시작
		if (idx == 3) {
			// 새 보드 만들고 필드에 있는 보드 게임 끝나고 주소값 다시 넣어주기
			int newBoard[][] = new int[N][M];
			for (int i = 0; i < N; i++) {
				newBoard[i] = board[i].clone();
			}

			// 게임 시작
			int counting = game();
			// 현재 잡은 궁수가 result안에 있는 값보다 많으면 멈춘다
			if (counting > result)
				result = counting;

			// 필드에 있는 주소값 다시 넣어주기
			board = newBoard;
			return;
		}

		// 궁수 배치
		for (int i = start; i < M; i++) {
			if (archerArr[i] == false) {
				archerArr[i] = true;
				archerArr(idx + 1, i + 1);
				archerArr[i] = false;
			}
		}
	}

	// 게임 시작 반환타입은 현재 궁수가 이 판에서 잡을 애들
	static int game() {

		// 현재 배치에서 궁수가 죽인 총 적의 개수
		int curtotal = 0;
		// 게임은 총 N번 진행됨
		for (int i = N - 1; i >= 0; i--) {
			//궁수가 공겨한 위치를 담을 배열
			Deque<int[]> deque = new ArrayDeque<>();
			
			// 현재 궁수의 위치를 for문으로 가져오기
			for (int j = 0; j < M; j++) {
				// 현재 위치에 아처가 있으면 true
				if (archerArr[j]) {
					// 활쏘기
					int[] temp = hunt(i, j);
					if(temp != null) {
						deque.offer(temp);
					}
				}
			}
			
			while(!deque.isEmpty()) {
				int[] temp = deque.poll();
				
				if(board[temp[0]][temp[1]] == 1) {
					board[temp[0]][temp[1]] = 0;
					curtotal++;
				}	
			}
			
//			for(int[] b : board) {
//				System.out.println(Arrays.toString(b));
//			}
//			System.out.println("===============");
		}

		return curtotal;
	}

	// 현재 선택된 궁수가 애들 잡기를 시작
	static int[] hunt(int row, int col) {

		int[] temp = new int[2];
		// 사거리만큼 for문을 돌릴거임
		// 높이 idx 따로 구하기
	

		// 높이가 0보다 작으면 break
		if (row < 0)
			return null;

		// 현재 궁수 바로 앞에 적이 있으면 제거 하고 return
		// 2는 이미 쏜 애들을 뜻함
		if (board[row][col] == 1) {
			temp[0] = row;
			temp[1] = col;
			return temp;
		}

		// 해당 위치에서 높이가 높아질 수록 대각선으로 가야되니 사거리에서 idx를 빼줘야함
		// 좌우 확인 후 쏘기

		for (int j = 1; j <= D; j++) {
			// 가장 왼쪽의 있는 적부터 공격해야됨
			for (int k = 1; k < j * 2; k++) {
				int x = row - (((j-1) - Math.abs(j-k)));
				int y = col - (j - k);
				
				if (y < 0 || y >= M || x < 0 || x >= N)
					continue;

				if (board[x][y] == 1) {
					temp[0] = x;
					temp[1] = y;
					return temp;
				}
			}
		}
		

		return null;
	}
}

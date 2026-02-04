import java.util.Scanner;

public class Main {

	/*
	 * 문제 : 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열
	 * 조건1 : 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
	 * 조건2 : 고른 수열은 오름차순이어야 한다.
	 * 
	 * 접근 방식 : 백트래킹을 이용해서 문제 풀이
	 */
	
	static int N,M;
	
	static int[] arr;
	
	static boolean[] visited;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//자연수 N
		N = sc.nextInt();
		
		//수열의 길이 M
		M = sc.nextInt();
		
		//직접 출력한 배열을 M의 크기만 큼 만든다
		arr = new int[M];
		
		//해당 자연수를 뽑을 논리 배열을 만들어준다
		visited = new boolean[N+1];
		
		//dfs는 0부터 시작
		dfs(0, 1);
		
	}
	
	public static void dfs(int depth, int startNum) {
		
		//해당 depth, 즉 M의 배열이 꽉차면 해당 
		if(depth == M) {
			StringBuilder str = new StringBuilder();
			
			for(int i = 0; i<M; i++) {
				if(i == M -1) {
					str.append(arr[i]);
				}else {
					str.append(arr[i] + " ");
				}
			}
			
			System.out.println(str);
			return;
		}
		
		for(int i = startNum; i<= N; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				arr[depth] = i;
				dfs(depth+1, i+1);
				visited[i] = false;
			}
		}
		
		
		/*
		  depth : 0
		  arr : {}
		 
		 
		 */
	}
}

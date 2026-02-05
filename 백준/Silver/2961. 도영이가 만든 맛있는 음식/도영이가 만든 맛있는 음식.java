import java.util.Scanner;

public class Main {
	
	//신맛과 쓴맛 배열
	static int[] sArr;
	static int[] bArr;

	//정답
	static int result = 0;
	
	//방문 조회
	static boolean[] visited;
	
	//재료의 개수
	static int N;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//재료의 개수
		N = sc.nextInt();
		
		//입력값들 넣는 배열
		sArr = new int[N];
		bArr = new int[N];
		
		visited = new boolean[N];
		
		
		
		for(int i = 0; i<N; i++) {
			//신맛, 곱
			int S = sc.nextInt();
			//쓴맛, 합
			int B = sc.nextInt();
			
			sArr[i] = S;
			bArr[i] = B;
		}
		
		result = Math.abs(sArr[0] - bArr[0]);
		
		dfs(1,0,0);
		

		
		System.out.println(result);
	}
	
	static void dfs(int s, int b, int depth) {
		
		int multiply = 0;
		int sum = 0;
		
		int diff1 = 0;
		int diff2 = 0;
		
		for(int i = depth; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				multiply = s * sArr[i];
				sum = b + bArr[i];
				
				diff1 = Math.abs(s-b) + Math.abs(sArr[i] - bArr[i]);
				diff2 = Math.abs(multiply - sum);
				
				result = Math.min(result, diff1);
				
				if(diff1 >= diff2) {
					result = Math.min(result, diff2);
					dfs(multiply, sum, depth+1);
				}
				visited[i] = false;
			}
			
		}
	}
	
}

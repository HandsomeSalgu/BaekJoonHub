import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<N; i++) {
			
			for(int j = 1; j<=N+i; j++) {			
				if(N-j-i > 0) sb.append(" ");
				else if(N - i == j || N + i == j) sb.append("*");
				else sb.append(" ");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
}

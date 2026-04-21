import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int n, m;
	static int[] intArr;
	
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		intArr = new int[n];
		
		for(int i = 0; i<n; i++) {
			intArr[i] = i;
		}
		
//		System.out.println(Arrays.toString(intArr));
		
		for(int i = 1; i<=m; i++) {
			boolean flag = union(sc.nextInt(), sc.nextInt());
			
			if(flag) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
		
	}
	
	static boolean union(int x, int y) {
		int from = findSet(y);
		int to = findSet(x);
		
//		System.out.println(Arrays.toString(intArr));
//		System.out.println("from : " + from);
//		System.out.println("to : " + to);
		
		if(from == to) {
			return true;
		}else {
			intArr[from] = findSet(to);
			return false;
		}
		
		
	}
	
	static int findSet(int x) {
		if(x!=intArr[x])
			intArr[x] = findSet(intArr[x]);
		return intArr[x];
	}
}
















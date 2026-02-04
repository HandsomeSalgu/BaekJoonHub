import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String T = sc.nextLine();
		String P = sc.nextLine();
		
//		System.out.println(T);
//		System.out.println(P);
		
		KMP(T,P);
		
	}
	
	static int[] computeLPS(String P) {
		int len = P.length();
		int[] pi = new int[len];
		
		int j = 0;
		
		//a a a b a a a c
		//0 1 2 0 1 2 3 0
		for(int i = 1; i<len; i++) {

			
			while(j > 0 && P.charAt(i) != P.charAt(j)) {
				j = pi[j-1];
			}
			
			if(P.charAt(i) == P.charAt(j))
				j++;
			
			pi[i] = j;
		}
		
		
		return pi;
	}
	
	static void KMP(String T, String P) {
		int count = 0;
		StringBuilder sb = new StringBuilder();
		
		int lenT = T.length();
		int lenP = P.length();
		
		int[] pi = computeLPS(P);
		
		int j = 0;
		
		for(int i = 0; i<lenT; i++) {
			
			while(j > 0 && T.charAt(i) != P.charAt(j)) {
				j = pi[j-1];
			}
			
			if(T.charAt(i) == P.charAt(j))
				j++;
			
			if(j == lenP) {
				count++;
				sb.append((i - lenP + 2) + " ");
				j = pi[j-1];
			}
			
			
		}
		
		System.out.println(count);
		System.out.println(sb);
	}
	
}

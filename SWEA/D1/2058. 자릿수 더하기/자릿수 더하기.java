import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//테스트 케이스
		String str = sc.nextLine();
		
		int sum = 0;
		
		for(int i = 0; i<str.length() ; i++) {
			sum += Integer.parseInt(str.charAt(i) + "");
		}
		
		System.out.println(sum);
	}
	
}
import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        //숫자의 개수
        int N = sc.nextInt();
        sc.nextLine();

        
        //숫자일단 문자로 받기
        String str = sc.nextLine();

        //총합
        int result = 0;

        //숫자 더하기
        for(int i = 0; i<N ; i++){
            result += Integer.parseInt(String.valueOf(str.charAt(i)));
            
        }

        System.out.println(result);

    }
}
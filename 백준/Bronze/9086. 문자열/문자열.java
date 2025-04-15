import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        //입력의 첫줄에는 테스트 케이스의 개수
        int T = sc.nextInt();
        sc.nextLine();

        //테스트 케이스들
        for(int i = 0; i < T ; i++){
            String str = sc.nextLine();

            //첫번째 문자
            char c1 = str.charAt(0);

            //마지막 문자
            char c2 = str.charAt(str.length()-1);

            System.out.println(c1 + "" + c2);
        }
    }
}
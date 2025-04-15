import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        //비교할 두 수
        StringBuilder str1 = new StringBuilder(sc.next());
        StringBuilder str2 = new StringBuilder(sc.next());

        //비교할 두 수 뒤집기
        int a = Integer.parseInt((str1.reverse()).toString());
        int b = Integer.parseInt((str2.reverse()).toString());

        //큰 수 구하기
        if(a > b){
            System.out.println(a);
        }else{
            System.out.println(b);
        }
    }
}
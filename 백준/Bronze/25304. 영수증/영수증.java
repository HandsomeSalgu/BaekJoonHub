import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        //총 금액
        int X = sc.nextInt();

        //구매한 물건의 종류의 수
        int N = sc.nextInt();
        
        //버퍼 값 지우기
        sc.nextLine();

        //총 금액과 비교할 금액
        int result = 0;

        for(int i = 0 ; i<N ; i++){
            //가격과 물건의 수
            String T = sc.nextLine();

            String[] array = T.split(" ");

            int a = Integer.parseInt(array[0]);
            int b = Integer.parseInt(array[1]);

            result += a*b;
        }

        if(X == result){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}

import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //제시한 숫자
        int N = sc.nextInt();

        if(N != 1){
            
            //처음으로 나눌 수
            int divide = 2;

            while(N != 1){
                if(N%divide == 0){
                    N /= divide;
                    System.out.println(divide);
                }else{
                    divide++;
                }
            }
        }
    }
}

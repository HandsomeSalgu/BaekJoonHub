import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        //몇 번째 방인디
        int N = sc.nextInt();

        //몇 번 통과해야되는지
        int result = 1;

        //두번째 방부터 기준
        int num = 2;

        //증감되는 방 갯수
        int plus = 6;

        //방 찾으면 false
        boolean flag = true;

        while(N != 1 && flag){
            result++;
            if(N >= num && N <= num+plus-1){
                flag=false;
            }else{
                num += plus;
                plus += 6;
            }
        }

        System.out.println(result);
    }

}

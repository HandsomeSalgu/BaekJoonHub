import java.util.HashMap;
import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //자연수 M
        int M = sc.nextInt();

        //자연수 N
        int N = sc.nextInt();

        //소수의 합
        int result = 0;

        //소수의 최소값
        int minNum = 0;
        for(int i = M; i<=N; i++){
            HashMap<Integer, String> map = new HashMap<>();

            for(int j = 1; j<=i; j++){
                if(i%j == 0){
                    map.put(j, "헤헤 아무거나 적어도 되지롱~");
                }
            }

            if(map.size() == 2){
                result += i;
                if(minNum == 0){
                    minNum = i;
                }
            }
        }
        if(result == 0){
            System.out.println(-1);
        }else{
            System.out.println(result);
            System.out.println(minNum);
        }
    }

}
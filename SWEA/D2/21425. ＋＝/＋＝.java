import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();

        for(int i = 0; i<T; i++){

            int x = sc.nextInt();
            int y = sc.nextInt();

            int N = sc.nextInt();

            int result = 0;
            
            while(x <= N && y <= N){
                
                if(x > y){
                    y += x;
                    
                }else{
                    x += y;
                }

                // System.out.println("x : " + x);
                // System.out.println("y : " + y);
                result++;
            }

            System.out.println(result);

        }
    }
}
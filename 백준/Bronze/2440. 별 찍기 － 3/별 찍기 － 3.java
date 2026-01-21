import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
      
        int N = sc.nextInt();

        for(int i = N; i>=1; i--){
            for(int j = 0; j<i; j++){
                System.out.print("*");
            }
            if(i != 0){
                System.out.println();
            }
            
        }
    }
}
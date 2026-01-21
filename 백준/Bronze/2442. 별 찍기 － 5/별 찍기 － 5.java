import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
      
        int N = sc.nextInt();

        for(int i = N; i>=1; i--){

            for(int k = 0; k<(i -1); k++){
                System.out.print(" ");
            }

            for(int j = 0; j<(N-i)*2 +1; j++){
                System.out.print("*");
            }


            if(i != 0){
                System.out.println();
            }     
        }    
    }
}
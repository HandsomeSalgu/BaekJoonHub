import java.util.Scanner;

public class Main{   
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int Z = sc.nextInt();

        for(int i = Z; i>0 ; i--){
            StringBuilder star = new StringBuilder();

            for(int j = 0; j<i-1 ; j++){
                star.append(" ");
            }

            for(int k = 0; k <= Z-i ;k++){
                star.append("*");
            }

            System.out.println(star);
        }
    }
}

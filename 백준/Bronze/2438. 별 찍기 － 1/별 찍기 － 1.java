import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int Z = sc.nextInt();
        StringBuilder star = new StringBuilder("*");

        for(int i = 0; i<Z ; i++){
            if(i != 0){
                star.append("*");
            }
            System.out.println(star);
        }

    }
}

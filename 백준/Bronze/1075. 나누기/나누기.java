import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int F = sc.nextInt();

        N = N-(N%100);
        int num = N%F;
        

        N += (F-num) == F ? 0 : (F-num);

        System.out.printf("%02d", (N%100));
    }
    
}
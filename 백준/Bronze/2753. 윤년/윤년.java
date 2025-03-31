import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int result = sc.nextInt();

        if(result%4 == 0 && (result%100 != 0 || result%400 == 0)){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}

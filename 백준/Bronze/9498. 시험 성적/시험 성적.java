import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int result = sc.nextInt();

        if(result >= 90){
            System.out.println("A");
        }else if(result >= 80){
            System.out.println("B");
        }else if(result >= 70){
            System.out.println("C");
        }else if(result >= 60){
            System.out.println("D");
        }else{
            System.out.println("F");
        }
    }
}

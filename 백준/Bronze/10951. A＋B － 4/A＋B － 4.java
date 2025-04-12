import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        while(true){
            try {
                String str = sc.nextLine(); // Ctrl+Z 누르면 예외 발생

                String[] array = str.split(" ");
                System.out.println(Integer.parseInt(array[0]) + Integer.parseInt(array[1]));

            } catch (NoSuchElementException e) {
                break;
            }
        }
    }
}
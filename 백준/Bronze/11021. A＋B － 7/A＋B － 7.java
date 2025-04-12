import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        //개수
        int T = sc.nextInt();
        sc.nextLine();

        for(int i = 1; i<=T; i++){
            String str = sc.nextLine();

            String[] array = str.split(" ");

            System.out.println("Case #" + i + ": " + (Integer.parseInt(array[0])+Integer.parseInt(array[1])));
        }

    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main{
    
    /*public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        // while(true){
        //     try {
        //         String str = sc.nextLine(); // Ctrl+Z 누르면 예외 발생

        //         String[] array = str.split(" ");
        //         System.out.println(Integer.parseInt(array[0]) + Integer.parseInt(array[1]));

        //     } catch (NoSuchElementException e) {
        //         break;
        //     }
        // }

        while(sc.hasNext()){
            String str = sc.nextLine();

            String[] array = str.split(" ");
            System.out.println(Integer.parseInt(array[0]) + Integer.parseInt(array[1]));
        }
        

    }*/

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            try {
                while(true){
                    String str = br.readLine();

                    if(str != null){
                        String[] array = str.split(" ");
                        int result = Integer.parseInt(array[0]) + Integer.parseInt(array[1]);
    
                        bw.write(result + "\n");
                    }else{
                        break;
                    }
                }

                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
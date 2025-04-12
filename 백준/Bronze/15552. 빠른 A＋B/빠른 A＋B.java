import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
    
    public static void main(String[] args) {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
        try {
            //테스트 개수
            int T = Integer.parseInt(br.readLine());

            for(int i = 0 ; i<T ; i++){
                String str = br.readLine();

                String[] array = str.split(" ");

                int result = Integer.parseInt(array[0]) + Integer.parseInt(array[1]);

                String result2 = Integer.toString(result);

                bw.write(result2 + "\n");

            }
            
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String StringN = br.readLine();

        int N = Integer.parseInt(StringN);

        int three = 0;
        int five = 0;
        int result = 0;

        if(N % 5 == 0){
            result = N / 5;
        }else{
            while(N >= 3){
                three++;
                N = N - 3;
                if(N % 5 == 0){
                    five = N / 5;
                    N = 0;
                    break;
                }
            }

            if(N == 0){
                result = three + five;
            }else{
                result = -1;
            }
        }

        

        bw.write(result + "");
        bw.flush();
    }
}
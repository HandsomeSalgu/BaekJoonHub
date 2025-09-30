import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    
    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        String str = "";

        while((str = br.readLine()) != null){
            int A = Integer.parseInt(str.split(" ")[0]);
            int B = Integer.parseInt(str.split(" ")[1]);
            sb.append(A + B).append("\n");

            
        }
        bw.write(sb + "");
        bw.flush();
    }
}
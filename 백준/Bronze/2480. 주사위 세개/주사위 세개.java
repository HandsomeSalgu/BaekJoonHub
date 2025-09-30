import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException{
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String bString = br.readLine();

        String[] bStrArr = bString.split(" ");

        int a = Integer.parseInt(bStrArr[0]);
        int b = Integer.parseInt(bStrArr[1]);
        int c = Integer.parseInt(bStrArr[2]);

        int result = 0;

        if(a==b && b==c && c==a){
            result = 10000 + 1000*a;
        }else if(a!=b && b!=c && c!=a){
            result = 100 * (Math.max(Math.max(a,b),c));
        }else{
            if(a==b){
                result = 1000 + 100 * a;
            }else if(a==c){
                result = 1000 + 100 * a;
            }else{
                result = 1000 + 100 * b;
            }
        }

        bw.write(result + "");
        bw.flush();
    }
}

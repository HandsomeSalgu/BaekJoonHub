import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력 값
        String str = br.readLine();
        br.close();

        //배열
        int[] iArr = new int[str.length()];

        for(int i = 0; i<str.length(); i++){
            iArr[i] = Integer.parseInt(str.charAt(i)+"");
        }
        
        Arrays.sort(iArr);

        for(int i = str.length()-1; i>=0; i--){
            bw.write(iArr[i]+"");
        }

        bw.flush();
        bw.close();
    }

}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //테스트 개수
        int T = Integer.parseInt(br.readLine());

        //반복 시작
        for(int i = 0; i<T ; i++){
            //테스트 케이스
            String str = br.readLine();

            String[] arr = str.split(" ");

            for(int j = 0; j<arr.length; j++){
                StringBuffer sb = new StringBuffer(arr[j]);

                bw.write(sb.reverse().toString() + " ");
            }

            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}

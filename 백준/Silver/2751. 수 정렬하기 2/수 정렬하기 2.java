import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //반복할 수 받기
        String str = br.readLine();
        
        //반복할 수 숫자로
        int N = Integer.parseInt(str);

        //배열
        ArrayList<Integer> list = new ArrayList<>();

        //List 안에 배열 담기
        for(int i = 0; i<N; i++){
            String str2 = br.readLine();
            int num = Integer.parseInt(str2);
            list.add(num);
        }

        Collections.sort(list);

        for(int i = 0; i<N; i++){
            bw.write(list.get(i) + "");
            if(i != N-1){
                bw.write("\n");
            } 
        }

        bw.flush();
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //소문자 글자 입력
        StringBuilder N = new StringBuilder(br.readLine());

        //입력할 명령어의 개수
        int M = Integer.parseInt(br.readLine());

        //현재 커서의 위치
        int cursor = N.length();

        for(int i = 0; i<M; i++){
            //명령어
            String str = br.readLine();

            if(str.equals("L")){
                if(cursor > 0){
                    cursor--;
                }
            }else if(str.equals("D")){
                if(cursor < N.length()){
                    cursor++;
                }
            }else if(str.equals("B")){
                if(cursor > 0){
                    N.deleteCharAt(cursor-1);
                    cursor--;
                }
                
            }else if(str.contains("P")){
                String appendStr = str.substring(2, 3);

                N.insert(cursor, appendStr);
                cursor++;
            }
        }

        br.close();
        bw.write(N.toString());
        bw.flush();
        bw.close();

    }
}

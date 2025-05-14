import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //명령 횟수
        int N = Integer.parseInt(br.readLine());

        //정수 저장하는 스택
        ArrayList<Integer> list = new ArrayList<>();

        //명령 입력
        for(int i = 0; i<N ; i++){
            String str = br.readLine();

            if(str.contains("push")){
                String[] strArr = str.split(" ");
                int X = Integer.parseInt(strArr[1]);
                list.add(X);
            }else if(str.equals("pop")){
                if(list.isEmpty()){
                    bw.write("-1");
                }else{
                    bw.write(list.get(list.size() -1) + "");
                    list.remove(list.size() -1);
                }
            }else if(str.equals("size")){
                bw.write(list.size() + "");
            }else if(str.equals("empty")){
                if(list.isEmpty()){
                    bw.write("1");
                }else{
                    bw.write("0");
                }
            }else if(str.equals("top")){
                if(list.isEmpty()){
                    bw.write("-1");
                }else{
                    bw.write(list.get(list.size() -1) + "");
                }
            }

            if(!str.contains("push") && i != N-1){
                bw.write("\n");
            } 
        }

        br.close();
        bw.flush();
        bw.close();
    }

}

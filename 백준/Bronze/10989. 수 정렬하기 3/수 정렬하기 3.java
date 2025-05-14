import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //반복할 수 받기
        String str = br.readLine();
        
        //반복할 수 숫자로
        int N = Integer.parseInt(str);

        //배열
        HashMap<Integer, Integer> map = new HashMap<>();

        //제일 작은 수
        int min = 0;

        //제일 큰 수
        int max = 0;

        //제일 큰수와 제일 작은 수 구한다
        //Map에다가 반복되는 숫자들을 넣어준다
        for(int i = 0; i<N; i++){
            String str2 = br.readLine();
            int num = Integer.parseInt(str2);

            if(i == 0){
                min = num;
                max = num;
            }else{
                min = Math.min(min, num);
                max = Math.max(max, num);
            }

            if(!(map.containsKey(num))){
                map.put(num, 1);
            }else{
                map.put(num, map.get(num) +1);
            }
        }

        //반복되는 숫자들 꺼내서 반복
        for(int i = min; i<=max; i++){
            if(map.containsKey(i)){
                int num = i;
                int repeat = map.get(i);

                for(int j = 0; j<repeat; j++){
                    bw.write(num + "");
                    if(!(i == max && j == repeat -1)){
                        bw.write("\n");
                    }
                }
            }
        }
        bw.flush();
    }
}

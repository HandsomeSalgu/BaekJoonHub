import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class Main{
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //좌표의 개수
        int N = Integer.parseInt(br.readLine());

        //좌표들
        String str = br.readLine();

        br.close();

        //배열
        String[] strArr = str.split(" ");
        int[] numArr = new int[N];

        //비교 배열
        int[] numArr2 = new int[N];

        for(int i = 0; i<N ; i++){
            numArr[i] = Integer.parseInt(strArr[i]);
            numArr2[i] = numArr[i];      
        }

        Arrays.sort(numArr2);

        //중복제거하기
        HashMap<Integer, Integer> map = new HashMap<>();
        int num = 0;

        for(int i = 0; i<N; i++){
            if(!map.containsKey(numArr2[i])){
                map.put(numArr2[i], num++);
            }
        }

        //출력
        for(int i = 0; i < N; i++){
            bw.write(map.get(numArr[i]) + " ");
        }

        bw.flush();
        bw.close();
    }
}

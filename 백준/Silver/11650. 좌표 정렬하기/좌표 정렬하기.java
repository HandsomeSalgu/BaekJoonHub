import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //N개의 점
        int N = Integer.parseInt(br.readLine());

        //이중 배열
        int[][] numArr = new int[N][2];

        for(int i = 0; i<N; i++){
            String str = br.readLine();

            String[] strArr = str.split(" ");

            //x좌표
            numArr[i][0] = Integer.parseInt(strArr[0]);

            //y좌표
            numArr[i][1] = Integer.parseInt(strArr[1]);
        }
        br.close();

        //Comparator를 이용해 이중배열 정렬 규칙 생성
        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b){
                //x 값이 같을 경우 y 오름차순
                if(a[0] == b[0]){
                    return a[1] - b[1];
                }else{
                    //아니면 x 오름차순
                    return a[0] - b[0];
                }
            }
        };

        Arrays.sort(numArr, comp);

        for(int i =0; i<N; i++){
            bw.write(numArr[i][0] + " " + numArr[i][1]);
            if(i != N-1){
                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
    }

}

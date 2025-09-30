import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //값 받아오기
        String StringN = br.readLine();

        //총 가져야될 설탕
        int N = Integer.parseInt(StringN);

        //결과 값(해당 안되면 -1
        int result = -1;

        //5로 나눴을 때 딱 맞아떨어지면 최소값은 N/5
        if(N % 5 == 0){
            result = N /5;
        }
        //5로 바로 안떨어지면 현재 설탕의 키로수에 최대 5kg의 수의 반복
        else{
            int fiveNum = N /5;

            for(int i = fiveNum; i>=0; i--){
                if((N - (5*i))%3 == 0){
                    result = ((N - (5*i))/3) + i;
                    break;
                }
            }
        }

        bw.write(result + "");
        bw.flush();
    }
}
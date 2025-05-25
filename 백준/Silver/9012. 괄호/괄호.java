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
        
        //테스트 개수
        int T = Integer.parseInt(br.readLine());

        //테스트 시작
        for(int i = 0; i<T ; i++){
            String str = br.readLine();
            String result = "NO";

            //문장의 괄호 개수가 홀수일 경우 VPS가 될 수 없음
            if(str.length()%2 == 0){

                //첫번째는 (, 마지막은 )로 끝남
                if(str.startsWith("(") && str.endsWith(")")){
                    
                    int num = 0;

                    String[] strArr = str.split("");

                    for(int j = 0; j<strArr.length; j++){
                        //앞에서부터 체크
                        if(strArr[j].equals("(")){
                            num++;
                        }else if(strArr[j].equals(")")){
                            num--;
                        }

                        //num이 0보다 작으면 VPS가 될 수 없음
                        // ((()))) <- 이것처럼 여는 거는 없는데 닫는게 한 개 더 생기면 안됨
                        //그래서 바로 for문 종료
                        if(num < 0){
                            break;
                        }

                        //마지막까지 왔는데 다 맞으면 result를 YES로 바꿔주기
                        if(j == strArr.length-1 && num == 0){
                            result = "YES";
                        }
                    }
                }
            }
            bw.write(result + "\n");  
        }
        br.close();
        bw.flush();
        bw.close();
    }

}

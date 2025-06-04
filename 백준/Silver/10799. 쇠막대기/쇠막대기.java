import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //쇠막대기와 레이저 배치
        String str = br.readLine();
        br.close();
        
        //Stack 객체 만들기
        Stack<Character> stack = new Stack<>();

        //정답
        int stickNum = 0;

        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                stack.push('(');
            }else{
                stack.pop();

                if(str.charAt(i-1) == '('){
                    stickNum += stack.size();
                }else{
                    stickNum++;
                }
            }
        }

        bw.write(stickNum + "");
        bw.flush();
        bw.close();
    }

}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class Main{
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //수열의 크기
        int N = Integer.parseInt(br.readLine());

        //스택
        Stack<Integer> stack = new Stack<>();

        //배열
        String str = br.readLine();
        br.close();

        String[] strArr = str.split(" ");

        //정답 배열
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = strArr.length-1; i>=0; i--){
            
            int num = Integer.parseInt(strArr[i]);

            //스택이 비어있지 않고, num이 스택의 제일 위에있는 숫자보다 작거나 같을 때는 오큰수가 될 수 없기 때문에
            //스택에서 값을 빼주고 아니면 빼지 않는다
            while(!stack.empty() && stack.peek() <= num){
                stack.pop();
            }

            //위에 과정을 거쳐 만약 스택에 남아있는 수는 제일 나중에 들어온 수, 즉 오큰수이기 때문에 그 값을 list에 넣어준다
            //그리고 스택이 비어있으면 오른쪽에 있는 수들보다 자신이 제일 높기 때문에 -1를 넣어준다
            //어차피 오른쪽에 있는 수들보다 자신이 높기 때문에 오큰수는 자신이 될 수 밖에 없다
            if(stack.empty()){
                list.add(-1);
            }else{
                list.add(stack.peek());
            }

            stack.push(num);            
        }

        Collections.reverse(list);

        

        String result = (list.toString()).replace("[", "")
                                         .replace("]", "")
                                         .replace(",", "");

        bw.write(result);       
        bw.flush();
        bw.close();
    }
}

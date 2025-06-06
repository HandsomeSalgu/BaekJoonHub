import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main{
    
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //총 횟수
        int N = Integer.parseInt(br.readLine());

        //피연산자
        String str = br.readLine();

        //구별지을 수 있게 각 문자열 사이에 띄어쓰기 넣어주기
        str = String.join(" ", str.split(""));

        //피연산자 안에 있는 알파벳마다 숫자 넣어주기
        String alphbetAll = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for(int i = 0; i < N; i++){
            String alphbet = alphbetAll.charAt(i) + "";
            str = str.replace(alphbet, br.readLine());
        }

        String[] strArr = str.split(" ");

        //스택
        Stack<Double> stack = new Stack<>();

        //계산
        for(int i = 0; i<strArr.length; i++){
            if("+-*/".indexOf(strArr[i]) == -1){
                stack.push(Double.parseDouble(strArr[i]));
            }else{
                double num2 = stack.pop();
                double num1 = stack.pop();
                if(strArr[i].equals("+")){
                    stack.push(num1 + num2);
                }else if(strArr[i].equals("-")){
                    stack.push(num1 - num2);
                }else if(strArr[i].equals("*")){
                    stack.push(num1 * num2);
                }else{
                    stack.push(num1 / num2);
                }
            }
        }

        bw.write(String.format("%.2f", stack.pop()));
        bw.flush();
        bw.close();

    }
}

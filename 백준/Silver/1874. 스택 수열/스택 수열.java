import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //제시된 숫자
        int N = Integer.parseInt(br.readLine());

        //배열
        int[] arr = new int[N];

        //배열에 숫자 넣기
        for(int i = 0; i<N; i++){
            arr[i] = i+1;
        }

        //제일 마지막 스택 숫자
        int stack = 0;

        //정답
        StringBuilder result = new StringBuilder();

        //최대 수면 그 때부터 오름차순으로 숫자 빼야되니깐 논리값 걸기
        boolean flag = true;

        //반복문 돌리기
        for(int i = 0; i<N; i++){
            int num = Integer.parseInt(br.readLine());

            // System.out.println("first num : " + num);

            if(flag){
                if(stack < num){
                    for(int j = stack; j<num; j++){
                        result.append("+\n");
                    }

                    result.append("-\n");

                    arr[num-1] = 0;
                    stack = num;
                    
                    if(num == N){
                        Arrays.sort(arr);
                        flag = false;
                    }
                    // System.out.println(Arrays.toString(arr));
                    // System.out.println("stack : " + stack);
                    // System.out.println("num : " + num);
                }else{
                    for(int j = stack; j>0; j--){
                        if(arr[j-2] != 0){
                            if(arr[j-2] == num){
                                arr[j-2] = 0;
                                result.append("-\n");
                                // System.out.println(Arrays.toString(arr));
                                // System.out.println("stack : " + stack);
                                // System.out.println("num : " + num);
                                break;
                            }else{
                                result.setLength(0);
                                result.append("NO");       
                                flag = false;           
                                // System.out.println(Arrays.toString(arr));   
                                // System.out.println("stack : " + stack);
                                // System.out.println("num : " + num);
                                break;      
                            }
                        }
                    }
                    /* 
                    if(arr[stack-2] == num){
                        arr[stack-2] = 0;
                        result.append("-\n");
                    }else{
                        result.setLength(0);
                        result.append("NO");                     
                        break;
                    }
                        */
                    if(!flag){
                        break;
                    }
                }
            }else{
                if(arr[stack-1] == num){
                    result.append("-\n");
                    stack--;
                }else{
                    result.setLength(0);
                    result.append("NO");
                    break;
                }
            }
            
        }

        br.close();
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}

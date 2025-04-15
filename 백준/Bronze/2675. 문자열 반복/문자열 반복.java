import java.util.Scanner;

public class Main{
    

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        //테스트 개수
        int T = sc.nextInt();

        //결과 단어
        StringBuilder resultStr = new StringBuilder();

        for(int i = 0; i<T ; i++){
            //반복횟수
            int R = sc.nextInt();

            //반복할 단어
            String S = sc.next();

            //반복할 단어마다 반복 시키기
            for(int j = 0; j<S.length() ;j++){
                for(int k = 0; k<R ; k++){
                    resultStr.append(S.charAt(j));
                }
            }

            if(i<T){
                resultStr.append("\n");
            }
        }
        System.out.println(resultStr);
    }
}
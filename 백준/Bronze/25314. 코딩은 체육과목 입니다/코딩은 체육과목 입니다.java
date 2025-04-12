import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        //입력 받는 수
        int a = sc.nextInt();
        
        //반복할 횟수
        int b = a/4;

        //정답
        StringBuilder result = new StringBuilder();

        for(int i = 0; i<b ; i++){
            if(i == 0){
                result.append("long");
            }else{
                result.append(" long");
            }
        }

        result.append(" int");

        System.out.println(result);

    }
}

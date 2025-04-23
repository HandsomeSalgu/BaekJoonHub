import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        //제시 숫자
        String N = sc.nextLine();

        //숫자화
        int num = Integer.parseInt(N);

        //분해합
        int deSum = 0;

        //정답
        int result = 0;

        for(int i = num; i>0; i--){
            deSum = 0;
            String str = i + "";
            
            //분해합 구하기
            for(int j = 0; j<str.length(); j++){
                deSum += Integer.parseInt(String.valueOf(str.charAt(j)));
            }
            
            if(num == i+deSum){
                result = i;
            }
        }

        System.out.println(result);
    }
}

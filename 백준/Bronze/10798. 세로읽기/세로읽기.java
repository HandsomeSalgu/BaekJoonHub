import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        //배열 담기
        String[][] arr = new String[5][15];

        //정답
        StringBuilder result = new StringBuilder();

        for(int i = 0; i<5; i++){
            //i번째 줄 입력
            String str = sc.nextLine();

            for(int j = 0; j<str.length(); j++){
                arr[i][j] = String.valueOf(str.charAt(j));
            }
        }
        
        //정답 반복문
        for(int i = 0; i<15; i++){
            for(int j = 0; j<5; j++){
                if(arr[j][i] != null){
                    result.append(arr[j][i]);
                }
            }
        }
       
        System.out.println(result);
    }

}
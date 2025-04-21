import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        //흰색 도화지
        int[][] totalArr = new int[100][100];

        //반복 횟수
        int N = sc.nextInt();

        //총 넓이
        int result = 0;

        for(int i = 0; i<N ; i++){
            //x축
            int x = sc.nextInt();

            //y축
            int y = sc.nextInt();

            for(int j = 0; j<10; j++){
                for(int k = 0; k<10; k++){
                    totalArr[x+j][y+k] = 1;
                }
            }
        }

        //정답
        for(int i = 0; i<100; i++){
            for(int j = 0; j<100; j++){
                if(totalArr[i][j] == 1){
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
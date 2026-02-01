import java.util.Scanner;

public class Solution {
   
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i = 1; i<=T; i++){

            int N = sc.nextInt();
            int M = sc.nextInt();

            int pSum[][] = new int[N+1][N+1];


            //누적합
            for(int row = 1; row<=N; row++){
                for(int col =1; col<=N; col++){
                    int num = sc.nextInt();

                    pSum[row][col] = pSum[row-1][col] + pSum[row][col-1] - pSum[row-1][col-1] + num;
                }
            }

            int maxNum = 0;

            for(int row = M; row<=N; row++){
                for(int col = M; col<=N; col++){
                    //누적합으로 해당 면적 파리 죽인 횟수 구하기
                    int curSum = pSum[row][col]
                                - pSum[row - M][col]
                                - pSum[row][col-M]
                                + pSum[row-M][col-M];

                    maxNum = Math.max(maxNum, curSum);
                }
            }

            System.out.printf("#%d %d\n", i, maxNum);

        }
    }
}
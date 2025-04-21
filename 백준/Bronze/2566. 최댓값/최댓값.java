import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[9][9];

        //최대값
        int maxNum = 0;

        //최대값 행
        int A = 0;

        //최대값 열
        int B = 0;

        for(int i = 0; i<9; i++){
            for(int j = 0; j<9 ; j++){
                arr[i][j] = sc.nextInt();

                if(maxNum <= arr[i][j]){
                    maxNum = arr[i][j];
                    A = i+1;
                    B = j+1;
                }
            }
        }

        System.out.println(maxNum);
        System.out.println(A + " " + B);

    }

}

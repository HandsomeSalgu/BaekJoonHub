import java.util.Arrays;
import java.util.Scanner;

public class Main{
 
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        //바구니 총 개수
        int N = sc.nextInt();

        //바구니를 몇 번 돌릴 건지
        int M = sc.nextInt();

        //총 바구니 배열
        int[] array = new int[N];

        //처음 공 배치
        for(int a = 0 ; a<N ; a++){
            array[a] = a+1;
        }

        int[] array2 = null;

        //공 내림차순
        for(int b = 0; b<M ; b++){

            //첫번째 바구니
            int i = sc.nextInt();
            //마지막 바구니
            int j = sc.nextInt();

            //i부터 j까지의 바구니 수
            array2 = new int[j-(i-1)];

            //i부터 j까지 공 배치
            for(int k = 0 ; k<array2.length ; k++){
                array2[k] = array[(j-1)-k];
            }

            //i부터 j까지 공배치를 원래 있던 바구니에 넣기
            for(int l = 0 ; l<array2.length ; l++){
                array[l+(i-1)] = array2[l];
            }
        } 

        System.out.println((Arrays.toString(array)).replaceAll("[\\[\\]\\,]", ""));

    }
}

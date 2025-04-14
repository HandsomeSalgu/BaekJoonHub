import java.util.Arrays;
import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        //바구니 총 개수
        int N = sc.nextInt();

        //바꿀려는 바구니
        int M = sc.nextInt();

        //바구니 나열
        int[] array = new int[N];

        //바구니 당 공 배치
        for(int a = 0; a<N ; a++){
            array[a] = a+1;
        }

        for(int b = 0; b<M; b++){
            //i번 바구니
            int i = sc.nextInt()-1;

            //j번 바구니
            int j = sc.nextInt()-1;

            //i번 바구니 공
            int k = array[i];

            //j번 바구니 공
            int l = array[j];

            array[i] = l;
            array[j] = k;
        }

        String result = Arrays.toString(array);
        System.out.println(result.replaceAll("[\\[\\]\\,]", ""));

    }
}
import java.util.Arrays;
import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        //바구니 총 개수
        int N = sc.nextInt();

        //도현이가 넣을 공의 개수
        int M = sc.nextInt();

        int[] array = new int[N];

        for(int q = 0 ; q<M ; q++){
            //첫번째 바구니
            int i = sc.nextInt()-1;

            //마지막 바구니
            int j = sc.nextInt()-1;

            //넣을 번호의 공
            int k = sc.nextInt();

            for(int w = i ; w<=j ; w++){
                array[w] = k;
            }
        }

        String result = Arrays.toString(array);

        System.out.println(result.replaceAll("[\\[\\]\\,]", ""));

    }
}

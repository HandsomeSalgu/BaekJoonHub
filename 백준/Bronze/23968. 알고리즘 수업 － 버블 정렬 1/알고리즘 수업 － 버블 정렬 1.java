import java.util.Scanner;

public class Main {

    //K번째
    static int K;

    //정답
    static String result = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        K = sc.nextInt();

        int[] arr = new int[N];

        
    
        for(int i = 0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        //버블 배열
        bubbleSort(arr);

        if(result == null){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
    }


    public static void bubbleSort(int[] arr){

        //K번째 체크
        int count = 0;

        //배열 크기
        int N = arr.length;

        for(int i = 0; i<N-1; i++){
            for(int j = 0; j< N-1-i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    count++;
                }

                if(count == K){
                    result = arr[j] + " " + arr[j+1];
                    return;
                }
            }
        }

    }
}
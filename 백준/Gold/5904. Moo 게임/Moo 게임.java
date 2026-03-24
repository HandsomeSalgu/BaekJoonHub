import java.util.Scanner;
//Moo 수열은 다음과 같은 방법으로 재귀적으로 만들 수 있다.
//먼저, S(0)을 길이가 3인 수열 "m o o"이라고 하자. 1보다 크거나 같은 모든 k에 대해서,
// S(k)는 S(k-1)과 o가 k+2개인 수열 "m o ... o" 와 S(k-1)을 합쳐서 만들 수 있다.

//S(0) = 3
//S(1) = 10
//S(2) = 25
//S(3) = 56
//S(4) = 119
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        int k = 0;
        long sum = 3;

        while(sum < N){
            k++;
            sum = sum*2 +(3+k);
        }

        recursion(N, k, sum);
    }

    static void recursion(long N, int k, long sum){

        //만약 k가 0, 즉 끝에 도달했다면
        if( k == 0){
            if(N == 1) System.out.println("m");
            else System.out.println("o");
            return;
        }

        //현재 길이를 구해야되니깐 총 길이 sum에서 중간값인 (3+K)를 빼준뒤 나누기 2를하면 된다
        long curLen = (sum-(3+k))/2;

        //N이 curLen보다 작을 경우 왼쪽 S(k-1)로 가야된다
        if(curLen > N){
            recursion(N, k -1, curLen);
        }
        //N이 가운데에 해당된다면 첫글자면 m, 나머지는 o를 뱉으면 된다
        else if(N > curLen && N <= curLen + k + 3){
            if(N - curLen == 1){
                System.out.println("m");
            }else{
                System.out.println("o");
            }
        }
        // 나머지 경우는 오른쪽 S(k-1)로 간다
        // N은 위치 조정
        else{
            recursion(N-(curLen + k + 3), k -1, curLen);
        }
    }
}


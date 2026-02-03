import java.util.Arrays;
import java.util.Scanner;

public class Main {

    //자연수 N
    static int N;

    //길이
    static int M;

    //길이 만큼 출력할 배열
    static int[] arr;

    //현재 방문했는지 안했는지 체크
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];

        //안헷갈리게 1부터 탐색
        visited = new boolean[N+1];

        dfs(0);
    }


    static void dfs(int depth){
        if(depth == M){
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i<M; i++){
                if(i == M-1){
                    sb.append(arr[i]);
                }else{
                    sb.append(arr[i] + " ");
                }
            }

            System.out.println(sb);
            return;
        }

        for(int i = 1; i<=N; i++){
            if(visited[i] == false){
                visited[i] = true;
                arr[depth] = i;

                // System.out.println("arr : " + Arrays.toString(arr));
                // System.out.println("visited : " + Arrays.toString(visited));
                
                dfs(depth+1);

                visited[i] = false;
            }
        }
    }
}
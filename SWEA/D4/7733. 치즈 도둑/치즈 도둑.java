import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    //맛있는 정도의 배열
    static boolean[] deliArr;

    //한 변의 길이
    static int N;

    //보드
    static int[][] board;

    //상우하좌
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    //정답
    static int result;

    //방문 배열
    static boolean[][] visited;

    //노드
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int TC = 1; TC<=T; TC++){
            N = sc.nextInt();

            deliArr = new boolean[101];
            board = new int[N][N];
            result = 1;

            for(int i = 0; i<N; i++){
                for(int j = 0; j<N; j++){
                    int tmp = sc.nextInt();
                    board[i][j] = tmp;
                    deliArr[tmp] = true;
                }
            }

            for(int i = 1; i<=100; i++){
                if(deliArr[i])
                    game(i);
            }

            System.out.printf("#%d %d\n",TC,result);
        }
    }

    static void game(int eatBlock){

        //방문 배열 하나 만들기
        visited = new boolean[N][N];

        //덩어리 개수
        int count = 0;

        for(int x = 0; x<N; x++){
            for(int y = 0; y<N; y++){
                if(!visited[x][y] && board[x][y] > eatBlock){
                    bfs(eatBlock, x, y);
                    count++;
                }
            }
        }

        result = Math.max(result,count);
    }

    static void bfs(int eatBlock, int x, int y){
        Deque<Node> dq = new ArrayDeque<>();

        dq.offer(new Node(x,y));

        while(!dq.isEmpty()){
            Node curNode = dq.poll();

            if(visited[curNode.x][curNode.y])
                continue;

            visited[curNode.x][curNode.y] = true;

            for(int i = 0; i<=3; i++){
                int mx = curNode.x + dx[i];
                int my = curNode.y + dy[i];

                //맵 밖 확인
                if(mx < 0 || my < 0 || mx >= N || my >= N)
                    continue;

                //가는 쪽이 eatBlock보다 작으면 넘어가기
                if(board[mx][my] <= eatBlock)
                    continue;

                //아니면 ㄱㄱ
                dq.offer(new Node(mx,my));
            }
        }
    }
}

/* 2468 안전영역
[문제 제시]
- 재난방재청에서는 많은 비가 내리는 장마철에 대비할려고 한다

[문제 파악]
- 먼저 어떤 지역의 높이 정보를 파악한다.
- 그 다음에 그 지역에 많은 비가 내렸을 때 물에 잠기지 않는 '안전한 영역'이 최대로 몇 개가 만들어지는 지를 조사
- 문제를 간단하게 하기 위하여, 장마철에 내리는 비의 양에 따라 일정한 높이 이하의 모든 지점은 물에 잠긴다는 가정
- 물에 잠긴 곳은 회색 표시로 해서, 물에서 안전한 안전 영역은 총 몇개인지 구하는 문제

[로직 생각]
- 숫자를 담을 기본 배열과 잠겼는지 안잠겼는지 확인하는 논리형 배열 만들기
- 비의 양을 따라 해당 논리형 배열에 잠긴 부분 true로 만들어주기
- 안잠긴 곳을 기준으로 깊이 우선 탐색을 이용해 뻗어가는 곳 전부 탐색하면서 간 곳은 다 true로 만들어버리기
- 그래서 안전구역 총 개수 구하기
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

     // 보드의 크기
    static int N;

    // 해당 숫자를 담을 기본 배열 만들기
    static int[][] board;

    //최대 숫자
    static int maxNum;

    // 물의 높이에 따라 잠긴 부분을 true로 만들어준 논리형 배열 만들기
    static boolean[][] visited;

    // 상우하좌
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        sc.nextLine();

        board = new int[N][N];
        maxNum = 1;

        // 물의 높이를 담는데, 중복되면 안되니깐 set으로 담기
        Set<Integer> set = new HashSet<>();
        
        // 숫자 담기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
            int idx = 0;
            while (st.hasMoreTokens()) {
                int temp = Integer.parseInt(st.nextToken());
                board[i][idx++] = temp;
                set.add(temp);
            }
        }


        //물의 높이 만큼 set에 담아서 출력하기
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            // 물의 높이
            int waterLevel = it.next();

            //현재 물의 높이의 최대 안전 영역 개수
            int curSafeNum = 0;

            // 물의 높이에 따라 잠긴 부분을 true로 만들어준 논리형 배열 만들기
            visited = new boolean[N][N];

            // 물의 높이에따라 체크
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(waterLevel >= board[i][j]){
                        visited[i][j] = true;
                    }
                }
            }

            // for(int i = 0; i<N;i++){
            //     System.out.println(Arrays.toString(visited[i]));
            // }

            //지금부터 안전 영역 체크 시작
            for(int i = 0; i < N; i++){
               for(int j = 0; j < N; j++){
                    if(!visited[i][j]){
                        bfs(i,j);
                        curSafeNum++;
                    }
                } 
            }

            // System.out.println("waterLevel : " + waterLevel);
            // System.out.println("curSafeNum : " + curSafeNum);
            

            //안전영역 체킹 후 현재 제일 큰 수랑 비교
            maxNum = curSafeNum > maxNum ? curSafeNum : maxNum;
        }

        System.out.println(maxNum);
    }

    static void bfs(int col, int row){
        //일단 현재 위치 true로 만들어주기
        visited[col][row] = true;

        //4방향으로 돌면서 해당 구역이 있으면 직진하기
        for(int i = 0; i<4; i++){
            int mx = col + dx[i];
            int my = row + dy[i];

            //일단 mx와 my가 0보다는 크고 해당 보드의 크기보다는 작아야됨
            if(mx < 0 || mx >= N || my < 0 || my >= N )
                continue;

            //그리고 해당 이동 위치가 물에 잠겼거나, 이미 이동했는지 확인해야됨
            if(visited[mx][my])
                continue;

            //재귀함수로 계속 탐색
            bfs(mx, my);
        }
    }

}
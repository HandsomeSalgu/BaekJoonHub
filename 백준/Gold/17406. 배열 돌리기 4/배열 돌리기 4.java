import java.util.*;

public class Main {

    // 배열의 크기 및 배열
    static int N;
    static int M;
    static int[][] board;

    //회전 연산의 개수
    static int K;

    //회전 연산의 개수 안 숫자들 배열
    static int[][] roNumArr;

    //최솟값 구하기
    static int result = Integer.MAX_VALUE;

    //재귀로 현재 visited했는지 안했는지 확인
    static boolean[] visited;

    //순서 담는 배열
    static int[] intArr;

    //우하좌상
    static int[] dx = {0 ,1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        //처음에 행의 합을 구하기 위해 사용
        board = new int[N][M + 1];
        K = sc.nextInt();

        //보드 배치
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int temp = sc.nextInt();
                board[i][j] = temp;
                board[i][M] += temp;
            }

//            result = Math.min(result, board[i][M]);
        }


        //회전 연산의 개수안의 숫자들 배열로 담기
        roNumArr = new int[K][3];

        sc.nextLine();
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
            int idx = 0;
            while (st.hasMoreTokens()) {
                roNumArr[i][idx++] = Integer.parseInt(st.nextToken());
            }
        }

        //방문 횟수 만큼 visited 크기 늘리기
        visited = new boolean[K];

        //순서 담는 배열
        intArr = new int[K];

        //재귀로 순서 정하기
        recursive(0);

        System.out.println(result);
    }

    //재귀로 순서 정하기
    static void recursive(int idx) {
        //idx가 K이면 4가지 패턴이 완성됐다는 뜻
        if (idx == K) {

//            System.out.println(Arrays.toString(intArr));

            //제일 작은 수 구하기
            rotation();
            return;
        }
        //재귀 시작
        for (int i = 0; i < K; i++) {

            if (visited[i])
                continue;
            visited[i] = true;
            intArr[idx] = i;

            recursive(idx + 1);
            visited[i] = false;
        }
    }

    //돌려버리기
    static void rotation() {

        int idx = 0;

        //돌릴 보드 복사하기
        int[][] copyBoard = new int[N][];
        for (int i = 0; i < N; i++) {
            copyBoard[i] = Arrays.copyOf(board[i], M + 1);
        }

        //돌리기 전 준비해야될 것들
        while (idx != K) {
            int[] tempArr = roNumArr[intArr[idx++]];
            int r = tempArr[0];
            int c = tempArr[1];
            int s = tempArr[2];

            //제일 왼쪽 위 좌표(-1은 인덱스 맞추기)
            int frontX = r - s - 1;
            int frontY = c - s - 1;

            //제일 오른쪽 아래 좌표
            int endX = r + s - 1;
            int endY = c + s - 1;


            //이제 안에서 돌려버리기
            //돌릴려면 front와 end 둘 다 좌표가 같지 않아야 한 바퀴 돌 수 있다
            while (frontX < endX && frontY < endY) {

                int curX = frontX;
                int curY = frontY;

                //돌리기전 현재 값 저장
                int curTemp = copyBoard[curX][curY];

                //다음 좌표값
                int nextTemp = 0;

                //돌리고 돌리고오~ (우하좌상)
                for(int i = 0; i<4; i++){

                    while(true){
                        //좌표이동
                        int nextX = curX + dx[i];
                        int nextY = curY + dy[i];

                        //이동한 좌표가 지정된 좌표 이상으로 넘어가면 멈추기
                        if(nextX < frontX || nextY < frontY || nextX > endX || nextY > endY)
                            break;

                        //일단 nextTemp에 다음 좌표의 값 저장
                        nextTemp = copyBoard[nextX][nextY];

                        //현재 좌표 값 다음 좌표 값에 넣기
                        copyBoard[nextX][nextY] = curTemp;

                        //기존에 있던 좌표 값 현재 좌표 값에 넣기
                        curTemp = nextTemp;

                        curX = nextX;
                        curY = nextY;
                    }
                }

                //좌표 더해서 안쪽으로 들어가기
                frontX++;
                endX--;
                frontY++;
                endY--;
            }
        }

        //돌린 보드 보기
//        for(int[] b : copyBoard){
//            System.out.println(Arrays.toString(b));
//        }
//
//        System.out.println("----------------------");


        //다 구했으면 이제 여기서 최소 구해보자~~
        for (int i = 0; i < N; i++) {
            int sumNum = 0;

            for (int j = 0; j < M; j++) {
                int temp = copyBoard[i][j];
//                System.out.println(i + " " + j + " " + temp);
                sumNum += temp;
            }

//            System.out.println(sumNum);


            result = Math.min(result, sumNum);
        }

    }
}

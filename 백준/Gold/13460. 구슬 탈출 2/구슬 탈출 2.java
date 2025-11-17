import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    //보드의 세로 크기 : N
    //보드의 가로 크기 : M
    static int N;
    static int M;

    //보드를 저장하는 2차원 배열
    static char[][] board;

    //빨간 구슬, 파란 구슬의 위치에 대해 이미 위치했던 곳을 체크하는 4차원 배열
    static boolean[][][][] visited;

    //빨간 구슬의 위치와 파란 구슬의 위치를 저장하는 공 클래스
    static class Ball {
        int rx, ry, bx, by, count;

        Ball(int ry, int rx, int by, int bx, int count){
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.count = count;
        }
    }

    //공 움직일 때 사용하는 x와 y축(상하좌우)
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //보드 크기 입력 값 받고 넣기
        String[] str = (br.readLine()).split(" ");

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;

        for(int i = 0; i<N; i++){
            String str2 = br.readLine();

            for(int j = 0; j<M ; j++){
                board[i][j] = str2.charAt(j);

                if(str2.charAt(j) == 'R'){
                    rx  = j; ry = i;
                }else if(str2.charAt(j) == 'B'){
                    bx = j; by = i;
                }
            }
        }

        //출력
        bw.write(bfs(ry, rx, by, bx) +"");
        bw.flush();

    }

    //bfs : 너비 우선 탐색 알고리즘
    static int bfs(int ry, int rx, int by, int bx){

        //Queue를 만들고 거기에 초기 빨간공의 위치와 파란공의 위치를 넣기
        //count는 아직 한 번도 안움직였으니깐 0
        Queue<Ball> q = new LinkedList<>();
        q.offer(new Ball(ry, rx, by, bx, 0));

        //현재 두 개의 공 위치를 방문했다는 의미로 true 값 저장
        visited[ry][rx][by][bx] = true;

        //q 스택이 비어있기 전까지 반복
        while(!q.isEmpty()){
            Ball current = q.poll();

            //10번 이하로 움직여서 빨간 구슬을 구멍에 뺄 수 없으면 -1 출력
            if(current.count >= 10) return -1;

            //4방향으로 기울이기 시도
            for(int i = 0; i<4; i++){
                int[] red = roll(current.ry, current.rx, i);
                int[] blue = roll(current.by, current.bx, i);

                int nrx = red[1], nry = red[0];
                int nbx = blue[1], nby = blue[0];
                boolean redHole = red[2] == 1;
                boolean blueHole = blue[2] == 1;

                //파란공이 빠져버리면 해당 반복문 스킵
                if(blueHole == true) continue;

                //빨간공만 빠지면 성공
                if(redHole == true) return current.count+1;

                //공 둘이 겹쳐버리면 위치 조정
                if(nrx == nbx && nry == nby){
                    if(red[3] > blue[3]){ //빨간공이 더 많이 움직임
                        nrx -= dx[i];
                        nry -= dy[i];
                    }else{
                        nbx -= dx[i];
                        nby -= dy[i];
                    }
                }

                if(!visited[nry][nrx][nby][nbx]){
                    q.offer(new Ball(nry, nrx, nby, nbx, current.count+1));
                }
            }
        }

        return -1;
    }

    //공이 벽까지 굴러갈 때 까지 사용하는 메소드
    static int[] roll(int y, int x, int dir){
        //같은 방향으로 공이 가다가 겹쳐버리는 불상사를 대비해 moved를 만들어둠
        int moved = 0;
        while(true){
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            //굴러갈 방향에 벽이면 멈춤
            if(board[ny][nx] == '#') break;

            //굴러갈 방향에 출입구면 바로 반환
            if(board[ny][nx] == 'O'){
                return new int[]{ny, nx, 1 ,moved+1};
            }
            
            x = nx;
            y = ny;
            moved++;
        }

        return new int[]{y, x, 0, moved};
        
    }
}
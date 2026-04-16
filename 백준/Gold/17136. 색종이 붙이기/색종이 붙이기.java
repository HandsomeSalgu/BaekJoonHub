import java.util.Arrays;
import java.util.Scanner;

public class Main {

    //배열
    static int[][] intArr;

    //1의 개수
    static int OneCount;

    //정답
    static int minNum = Integer.MAX_VALUE;

    //색종이 사이즈별 담은 배열
    static int[] paperArr = new int[]{0, 5, 5, 5, 5, 5};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //배열
        intArr = new int[10][10];

        for(int i = 0; i<10; i++){
            for(int j = 0; j<10; j++){
                int temp = sc.nextInt();
                intArr[i][j] = temp;

                if(temp == 1)
                    OneCount++;
            }
        }
        dfs(0,0,0);

        if(minNum == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(minNum);
        }

    }

    //x와 y는 현재 좌표, count는 지금 몇장을 붙였는지
    static void dfs(int x, int y, int count){
        //현재 최소값보다 같거나 커지면 더 탐색할 필요가 없음
        if(count >= minNum)
            return;

        //줄바꿈 처리
        if(y==10){
            dfs(x+1, 0, count);
            return;
        }

        //마지막 줄 x=9 까지 다 돌고 10에 도달했을 때
        if(x==10){
            minNum = Math.min(count, minNum);
            return;
        }

        //현재칸이 0이면 무조건 다음 칸으로 스킵
        if (intArr[x][y] == 0) {
            dfs(x, y + 1, count);
            return;
        }

        for(int i = 5; i>=1; i--){
            if(check(x,y,i) && paperArr[i] > 0){
                //0으로 만들어주기
                attach(x,y,i,0);
                paperArr[i]--;

                dfs(x, y+1, count+1);

                attach(x,y,i,1);
                paperArr[i]++;
            }
        }
    }

    static boolean check(int x, int y, int size){

        for(int i = x; i<x+size ; i++){
            for(int j = y; j<y+size; j++){
                //일단 밖으로 나가버리면 색종이 못붙여서 false 반환
                if(i > 9 || j > 9)
                    return false;
                //이 사이즈 안에 0이 한개라도 나오면 반환
                if(intArr[i][j] == 0)
                    return false;
            }
        }

        return true;
    }

    static void attach(int x, int y, int size, int num){
        for(int i = x; i<x+size ; i++){
            for(int j = y; j<y+size; j++){
                intArr[i][j] = num;
            }
        }
    }
}
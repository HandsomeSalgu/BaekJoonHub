import java.util.*;

public class Main {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //시험의 단원 개수
        int N = sc.nextInt();

        //공부할 수 있는 총 시간
        int T = sc.nextInt();

        //시간과 무게를 담은 배열 0 : 시간 , 1은 점수
        int[][] intArr = new int[N][2];

        for(int i = 0; i< N; i++){
            intArr[i][0] = sc.nextInt();
            intArr[i][1] = sc.nextInt();
        }

        //점수를 넣어준 배열
        int[][] scoreArr = new int[T+1][N];

        for(int i = 0; i<=T ; i++){

            for(int j = 0; j< N; j++){

                //i가 0일 때는 어차피 시간이 0이므로 담을 수 있는 게 없음
                if(i == 0){
                    scoreArr[i][j] = 0;
                }
                //i가 1이상, 즉 시간이 주어졌을 때
                else{
                    //현재 시간
                    int curTime = intArr[j][0];

                    //현재 점수
                    int curScore = intArr[j][1];

                    //만약 j가 0이면 처음 담는 무게이기 때문에 해당 시간이 초과하면 0을 넣고 같거나 작으면 해당 점수값을 넣는다
                    if(j == 0){

                        if(curTime > i){
                            scoreArr[i][j] = 0;
                        }else{
                            scoreArr[i][j] = curScore;
                        }
                    }
                    else{

                        //만약 현재 시간이 i를 초과하면 전에 있던 시간을 넣으면 된다
                        if(curTime > i){
                            scoreArr[i][j] = scoreArr[i][j-1];
                        }

                        else{
                            //현재시간이 i와 같거나 클 때 현재 점수에서 현재 시간에 i를 뺀 인덱스의 값을 더해서
                            //그전에 까지 담았던 i번째 점수와 비교했을 때 크면 현재점수에서 현재시간에서 i를 뺀 인덱스점의 점수를 넣고
                            //그게 아니라면 그 전에 있던 값을 그대로 들고오면 된다
                            curScore += scoreArr[i-curTime][j-1];
                            scoreArr[i][j] = Math.max(scoreArr[i][j-1], curScore);
                        }
                        //
                    }
                    //

                }
            }
        }

//        for(int[] i : Arr){
//            System.out.printlscoren(Arrays.toString(i));
//        }

        System.out.println(scoreArr[T][N-1]);
    }
}
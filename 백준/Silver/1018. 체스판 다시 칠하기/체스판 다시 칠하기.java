import java.util.Arrays;
import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        //세로
        int M = sc.nextInt();

        //가로
        int N = sc.nextInt();

        //칠해야되는 색깔, 비교해야될 색깔
        int paintNum = 0;

        //일단 이중 배열에 전부 담기
        String[][] resultArr = new String[M][N];

        String[][] strArr = new String[M][N];

        for(int i=0; i<M; i++){
            String str = sc.next();
            for(int j=0; j<N; j++){
                resultArr[i][j] = String.valueOf(str.charAt(j));
            }
        }

        //이중 배열에 담았으니깐 8*8로 엮어서 비교하기
        //세로 줄 기준으로 비교, 만약 세로 줄이 8줄이면 반복 필요 없음, 9줄이면 1번 반복 이런식으로
        for(int i=0; i<M-7; i++){

            //안에 가로줄 비교, 얘도 가로가 8개면 반복 필요x, 9개면 1번 반복 이런 식으로
            for(int k=0; k<N-7; k++){
            //비교 숫자 초기화
            int compareNum = 0;

            //비교해줄 배열
            for(int q=0; q<M; q++){
                for(int w=0; w<N; w++){
                    strArr[q][w] = resultArr[q][w];
                }
            }

                //본격 적으로 세로 줄 비교, i를 더한 이유는 9줄이면 두번째 비교에서는 2번째 줄부터 시작해야됨
                for(int j=i; j<8+i; j++){
                
                    //본격 적으로 가로 줄 비교, 7까지 비교하는 이유는 마지막꺼는 뒤에 비교할 게 없기 때문에
                    for(int l=k; l<7+k; l++){

                        //j와 i가 같은 경우 첫번째 줄에 해당되기 때문에 그냥 옆에 있는 문자와 비교,
                        //다를 경우 2번째 줄부터이기 때문에 위에 줄과 비교
                        if(j!=i && strArr[j][k].equals(strArr[j-1][k])){
                            if(strArr[j][l].equals("W")){
                                strArr[j][l] = "B";
                            }else{
                                strArr[j][l] = "W";
                            }
                            compareNum++;
                        }
                        
                        //옆 문자와 비교
                        if(strArr[j][l].equals(strArr[j][l+1])){
                            if(strArr[j][l].equals("W")){
                                strArr[j][l+1] = "B";
                            }else{
                                strArr[j][l+1] = "W";
                            }
                            compareNum++;
                        }     
                    }
                }

                if(compareNum > 32){
                    compareNum = 64-compareNum;
                }

                if(i == 0 && k == 0){
                    paintNum = compareNum;
                }else{
                    if(paintNum > compareNum){
                        paintNum = compareNum;
                    }
                }
            }

            
        }

        System.out.println(paintNum);

    }
}

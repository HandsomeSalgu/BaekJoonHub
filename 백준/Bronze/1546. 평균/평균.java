import java.util.Arrays;
import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        //시험 과목 갯수
        int testNum = sc.nextInt();

        //시험 과목 정렬
        int[] test = new int[testNum];

        for(int i = 0; i<testNum ; i++){
            test[i] = sc.nextInt();
        }

        //오름차순으로 정렬
        Arrays.sort(test);

        //최고 점수
        double maxScore = test[testNum-1];

        //총 점수
        double totalScore = 0;

        //최고 점수 외에 나머지 점수 조작
        for(int i = 0; i<testNum; i++){
            double changeScore = test[i]/maxScore*100;

            totalScore += changeScore;
        }

        //평균점수
        double avg = totalScore/testNum;

        System.out.println(avg);
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        //교실 학생 총 수 배열
        int[] array = new int[30];

        //제출 안한 학생 배열
        ArrayList<Integer> aList = new ArrayList<>();

        //제출한 학생 배열에 넣기
        for(int i = 0; i<28; i++){

            //제출한 학생 번호
            int accept = sc.nextInt();

            array[accept-1] = accept;
        }

        //제출 안한 학생 찾기
        for(int j = 0; j<30 ; j++){
            if(array[j] == 0){
                aList.add(j+1);
            }
        }

        //오름차순으로 재배치
        Collections.sort(aList);
        
        int max = aList.get(1);
        int min = aList.get(0);

        System.out.println(min);
        System.out.println(max);
    }
}
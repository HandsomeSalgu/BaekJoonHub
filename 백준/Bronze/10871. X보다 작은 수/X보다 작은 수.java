import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> aList = new ArrayList<>();
        ArrayList<Integer> bList = new ArrayList<>();

        // 정수 N개
        int N = sc.nextInt();

        // 정수 X
        int X = sc.nextInt();

        // 수열
        for(int i = 0 ; i<N ; i++){
            aList.add(sc.nextInt());
        }

        // 비교
        for(int j = 0 ; j<aList.size(); j++){
            if(aList.get(j) < X){
                bList.add(aList.get(j));
            }
        }   

        System.out.println((bList.toString()).replaceAll("[\\[\\]\\,]", ""));

    }
}
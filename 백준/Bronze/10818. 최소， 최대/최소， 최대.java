import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //정수
        int N = sc.nextInt();

        ArrayList<Integer> aList = new ArrayList<>();

        for(int i = 0; i<N ; i++){
            aList.add(sc.nextInt());
        }

        
        //최대값
        int max = aList.get(0);

        //최소값
        int min = aList.get(0);

        for(int j = 1 ; j<aList.size(); j++){
            
            if(max < aList.get(j)){
                max = aList.get(j);
            }

            if(min > aList.get(j)){
                min = aList.get(j);
            }

        }

        System.out.println(min+" " +max);
    }
}
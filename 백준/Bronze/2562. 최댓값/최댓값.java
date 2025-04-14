import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> aList = new ArrayList<>();

        while(sc.hasNextInt()){
            aList.add(sc.nextInt());
        }
        //최대값
        int max = aList.get(0);

        //순서
        int array = 1;

        for(int i = 1 ; i < aList.size(); i++){
            if(max < aList.get(i)){
                max = aList.get(i);
                array = i+1;
            }
        }

        System.out.println(max);
        System.out.println(array);
    }
}
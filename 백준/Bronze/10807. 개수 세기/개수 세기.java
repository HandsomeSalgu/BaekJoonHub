import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int result = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i<N ; i++){
            list.add(sc.nextInt());
        }

        int k = sc.nextInt();

        for(int j = 0; j<list.size(); j++){
            if(list.get(j) == k){
                ++result;
            }
        }

        System.out.println(result);
    }
}

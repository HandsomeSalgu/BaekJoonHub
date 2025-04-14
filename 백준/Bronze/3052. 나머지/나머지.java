import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        //숫자를 받는 배열
        ArrayList<Integer> aList = new ArrayList<>();

        for(int i = 0; i<10 ; i++){

            //나머지값
            int a = (sc.nextInt())%42;

            if(aList.size() == 0){
                aList.add(a);
            }else{
                boolean flag = true;

                for(int j = 0; j<aList.size() ; j++){
                    if(aList.get(j) == a){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    aList.add(a);
                }
            }
        }
        System.out.println(aList.size());
    }
}
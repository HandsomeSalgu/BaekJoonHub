import java.util.Arrays;
import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String[] strArr = str.split("");

        //결과값
        int result = 1;

        for(int i =0; i<strArr.length; i++){
            if(!strArr[i].equals(strArr[(strArr.length-1)-i])){
                result = 0;
            }
        }

        System.out.println(result);
    }

}

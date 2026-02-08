import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] intArr = new int[26];

        char[] charArr = (sc.next()).toCharArray();

        for(int i = 0; i< charArr.length; i++){
            intArr[charArr[i] - 'a']++;
        }

        for(int i : intArr){
            System.out.print(i + " ");
        }
    }
}
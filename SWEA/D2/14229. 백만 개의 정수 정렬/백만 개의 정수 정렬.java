import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");

        int[] aArr = new int[1_000_000];

        int idx = 0;
        while(st.hasMoreTokens()){
            aArr[idx++]= Integer.parseInt(st.nextToken());
        }

        Arrays.sort(aArr);

        System.out.println(aArr[500_000]);
    }

}









































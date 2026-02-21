import java.math.BigInteger;
import java.util.Scanner;

public class Main {

   

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger K = new BigInteger(sc.next());
        int L = sc.nextInt();
        
        boolean flag = true;
        int minNum = 0;

        for(int i = 2; i<L; i++){
            if(K.remainder(BigInteger.valueOf(i)).equals(BigInteger.ZERO)){
                flag = false;
                minNum = i;
                break;
            }
        }
        
        if(flag){
            System.out.println("GOOD");
        }else{
            System.out.println("BAD " + minNum);
        }
    }
}
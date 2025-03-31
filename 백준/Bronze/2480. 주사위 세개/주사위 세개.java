import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if(a == b && b == c && c == a){
            System.out.println(10000+(a*1000));
        }else if(a != b && b != c && c != a){
            int result = a > b ? (a>c ? a : (b>c ? b : c)) : (b > c ? b : (c > a ? c : a));
            System.out.println(result*100);
        }else{
            if(a == b && a !=c){
                System.out.println(1000 + (a*100));
                return;
            }
            if(a == c && a !=b){
                System.out.println(1000 + (a*100));
                return;
            }else{
                System.out.println(1000 + (b*100));
                return;
            }
        }
    }
}

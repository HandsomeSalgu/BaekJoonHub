import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int CH = C/60; 
        int CM = C%60;

        if(A+CH < 24 && B+CM < 60){
            System.out.println((A+CH) + " " + (B+CM));
        }else if(A+CH < 24 && B+CM >= 60){
            System.out.println(((A+CH)+1 == 24 ? 0 : (A+CH)+1) + " " + Math.abs(60-(B+CM)));
        }else if(A+CH >= 24 && B+CM < 60){
            System.out.println(Math.abs(24-(A+CH)) + " " + (B+CM));
        }else{
            System.out.println((Math.abs(23-(A+CH)) == 24 ? 0 : Math.abs(23-(A+CH))) + " " + Math.abs(60-(B+CM)));
        }
    }
}
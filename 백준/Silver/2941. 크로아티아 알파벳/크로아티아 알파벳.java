import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        //문자열 받기
        String str = sc.nextLine();

        //문자열 길이
        int result = str.length();

        //문자열 배열
        String[] strArr = str.split("");

        //크로아티아 알파벳 비교
        for(int i = 0; i<str.length()-1; i++){
            if(strArr[i].equals("c") && strArr[i+1].equals("=")){
                result--;
            }

            if(strArr[i].equals("c") && strArr[i+1].equals("-")){
                result--;
            }

            if(strArr[i].equals("d") && strArr[i+1].equals("-")){
                result--;
            }

            if(strArr[i].equals("l") && strArr[i+1].equals("j")){
                result--;
            }

            if(strArr[i].equals("n") && strArr[i+1].equals("j")){
                result--;
            }

            if(strArr[i].equals("s") && strArr[i+1].equals("=")){
                result--;
            }

            if(strArr[i].equals("z") && strArr[i+1].equals("=")){
                result--;
            }
        }

        for(int i = 0; i<str.length()-2; i++){
            if(strArr[i].equals("d") && strArr[i+1].equals("z") && strArr[i+2].equals("=")){
                result--;
            }
        }

        System.out.println(result);
    }

}
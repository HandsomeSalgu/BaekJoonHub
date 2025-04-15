import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        //단어 S
        String S = sc.nextLine();

        //비교할 단어
        String abc = "abcdefghijklmnopqrstuvwxyz";

        //단어 비교
        for(int i = 0; i<26; i++){

            int result = -1;

            for(int j = 0; j<S.length() ;j++){
                if(abc.charAt(i) == S.charAt(j)){
                    result = j;
                    break;
                }
            }

            System.out.println(result);
        }
    }
}
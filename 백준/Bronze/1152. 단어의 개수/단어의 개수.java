import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //단어
        StringBuilder strB = new StringBuilder();
        
        strB.append(sc.nextLine());

        if(strB.length() == 1){
            if(strB.charAt(0) == ' '){
                System.out.println(0);
            }else{
                System.out.println(strB.length());
            }
        }else{
            //공백문자 빼기
            if(strB.charAt(0) == ' '){
                strB.delete(0,1);
            }

            //공백문자 뺀 단어 넣기
            String str = strB.toString();

            String[] array = str.split(" ");

            System.out.println(array.length);
        }
        
    }
}
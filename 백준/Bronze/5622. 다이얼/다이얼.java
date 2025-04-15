import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        //문자 제시
        String str = sc.nextLine();

        //총 시간초
        int result = 0;

        for(int i = 0; i<str.length() ; i++){
            //문자 하나씩 뽑기
            char c = str.charAt(i);

            if(c == 'A' || c == 'B' || c == 'C'){
                result += 3;
            }else if(c == 'D' || c == 'E' || c == 'F'){
                result += 4;
            }else if(c == 'G' || c == 'H' || c == 'I'){
                result += 5;
            }else if(c == 'J' || c == 'K' || c == 'L'){
                result += 6;
            }else if(c == 'M' || c == 'N' || c == 'O'){
                result += 7;
            }else if(c == 'P' || c == 'Q' || c == 'R' || c == 'S'){
                result += 8;
            }else if(c == 'T' || c == 'U' || c == 'V'){
                result += 9;
            }else if(c == 'W' || c == 'X' || c == 'Y' || c == 'Z'){
                result += 10;
            }
        }

        System.out.println(result);
    }
}
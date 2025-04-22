import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        //숫자
        int N = sc.nextInt();

        //진법
        int B = sc.nextInt();

        //몇째짜리 까지인지 알아보기
        int size = 1;
        long ex = B;
        while(ex <= N){
            ex *= B;
            size++;
        }

        //B진법의 해당 자리수를 나타낸 문자열 배열
        String[] strArr = new String[size];
        //각 자리에 최고 수 넣기  
        for(int i =0; i<strArr.length ;i++){
            //배열의 제일 큰 수부터 차례대로 구하기
            for(int j = B; j>=0 ; j--){
                if(Math.pow(B,(strArr.length-1)-i)*j <= N){
                    N -= Math.pow(B,(strArr.length-1)-i)*j;
                    int num = 0;
                    if(j>=10){
                        num = j+55;
                        strArr[i] = String.valueOf((char)num);
                    }else{
                        num = j;
                        strArr[i] = num + "";
                    }
                    
                    break;
                }
            }
        }
        // System.out.println(size);

        for(int i = 0; i<strArr.length; i++){
            System.out.print(strArr[i]);
        }

        
    }
    

}

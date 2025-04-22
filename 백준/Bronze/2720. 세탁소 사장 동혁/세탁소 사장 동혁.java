import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        
        //테스트 케이스 개수
        int T = sc.nextInt();

        

        for(int i = 0; i<T ; i++){
            int[] numArr = new int[4];
            //받는 돈
            int C = sc.nextInt();

            if(C >= 25){
                numArr[0] = C / 25;
                C %= 25;
            }
            // System.out.println("1 : " + C);

            if(C >= 10){
                numArr[1] = C / 10;
                C %= 10;
            }
            // System.out.println("2 : " + C);

            if(C >= 5){
                numArr[2] = C / 5;
                C %= 5;
            }
            // System.out.println("3 : " + C);

            if(C >= 1){
                numArr[3] = C;
            }
            // System.out.println("4 : " + C);

            for(int j =0; j<numArr.length ; j++){
                if(j != numArr.length){
                    System.out.print(numArr[j] + " ");
                }else{
                    System.out.print(numArr[j]);
                }
                    
            }

            if(i != T){
                System.out.println();
            }
            
        }

        
    }

}

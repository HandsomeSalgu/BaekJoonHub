import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        //별 찍기 번호
        int N = sc.nextInt();

        StringBuilder str = new StringBuilder();

        
        for(int i = 1; i<=(N*2)-1 ; i++){

            //초반 별 찍기
            if(i<=N){
                //공백
                for(int j = 1 ; j<=(N-i); j++){
                    str.append(" ");
                }

                //별
                for(int k = 1 ; k<=1+((i-1)*2) ;k++){
                    str.append("*");
                }

            }

            //후반 별 찍기
            if(i>N){
                //공백
                for(int j = 1 ; j<=i-N; j++){
                    str.append(" ");
                }

                //별
                for(int k = 1 ; k<=((((N*2)-1)-i)*2)+1 ;k++){
                    str.append("*");
                }
                          
            }
            
            if(i<(N*2)-1){
                str.append("\n");
            }
        }
        System.out.println(str);
    }
}

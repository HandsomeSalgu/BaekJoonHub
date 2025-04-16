import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        for(int i = 0 ; i<6 ; i++){

            int num = sc.nextInt();

            if(i == 0){
                num = 1 - num;

            }else if(i == 1){
                num = 1 - num;

            }else if(i == 2){
                num = 2 - num;
                
            }else if(i == 3){
                num = 2 - num;
                
            }else if(i == 4){
                num = 2 - num;
                
            }else if(i == 5){
                num = 8 - num;  
            }

            System.out.println(num);
        }

    }

}

/* 우주선 착륙2
[문제 상황]
재웅이는 컴퓨터 10대를 가지고 있다
각 컴퓨터에 1번부터 10번까지 번호를 부여
10대의 컴퓨터가 다음 과  같은 방법으로 데이터 처리

1번 데이터는 1번 컴퓨터, 2번 데이터는 2번 컴퓨터, 3번 데이터는 3번 컴퓨터, ... ,
10번 데이터는 10번 컴퓨터, 11번 데이터는 1번 컴퓨터, 12번 데이터는 2번 컴퓨터, ...

총 데이터의 개수는 항상 a^b개의 형태로 주어짐
마지막 컴퓨터의 번호는?

[로직 작성]

*/

import java.util.Scanner;

public class Main {

    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 테스트 케이스
        int T = sc.nextInt();

        for (int TC = 1; TC <= T; TC++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int result= 0;

            a = a%10;
            switch(a){
            case 0: 
                result = 10; 
                break;
            case 1: 
                result = 1; 
                break;
            case 2: 
                switch(b%4){
                case 1 : 
                    result = 2;
                    break; 
                case 2: 
                    result = 4;
                    break; 
                case 3: 
                    result = 8;
                    break;
                case 0: 
                    result = 6;
                    break; 
                }
                break;
            case 3: 
                switch(b%4){
                case 1 : 
                    result = 3;
                    break; 
                case 2: 
                    result = 9;
                    break; 
                case 3: 
                    result = 7;
                    break;
                case 0: 
                    result = 1;
                    break; 
                }
                break;
            case 4: 
                switch(b%2){
                case 1 : 
                    result = 4;
                    break; 
                case 0: 
                    result = 6;
                    break; 
                }
                break;
            case 5: 
                result = 5; 
                break;
            case 6: 
                result = 6; 
                break;
            case 7: 
                switch(b%4){
                case 1 : 
                    result = 7;
                    break; 
                case 2: 
                    result = 9;
                    break; 
                case 3: 
                    result = 3;
                    break;
                case 0: 
                    result = 1;
                    break; 
                }
                break;
            case 8: 
                switch(b%4){
                case 1 : 
                    result = 8;
                    break; 
                case 2: 
                    result = 4;
                    break; 
                case 3: 
                    result = 2;
                    break;
                case 0: 
                    result = 6;
                    break; 
                }
                break;
            case 9: 
                switch(b%2){
                case 1 : 
                    result = 9;
                    break; 
                case 0: 
                    result = 1;
                    break; 
                }
                break;
            }

            System.out.println(result);
        }
    }
}

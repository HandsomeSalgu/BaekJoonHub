import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        HashMap<String, Integer> map = new HashMap<>();

        String str = (sc.nextLine()).toUpperCase();

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] alphabeArr = alphabet.split("");

        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> iList = new ArrayList<>();

        for(int i =0; i<alphabet.length(); i++){
            if(str.contains(alphabeArr[i])){

                int num = str.length();
                int num2 = str.replace(alphabeArr[i], "").length();

                int num3 = num-num2;

                list.add(alphabeArr[i]);
                iList.add(num3);
                
            }
        }

        String strResult = list.get(0);
        int intResult = iList.get(0);

        //큰 수 구하기
        for(int i = 1; i<list.size(); i++){
            if(intResult < iList.get(i)){
                strResult = list.get(i);
                intResult = iList.get(i);
            }
        }

        //중복 값 찾기
        int dupNum = 0;

        for(int i = 0; i<list.size(); i++){
            if(intResult == iList.get(i)){
                dupNum += 1;
            }
        }

        if(dupNum == 1){
            System.out.println(strResult);
        }else{
            System.out.println("?");
        } 
    }
}

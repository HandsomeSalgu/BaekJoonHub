import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //등급 점수화
        double ratingPoint = 0;

        //전공과목별의 학점 x 과목평점 합
        double gradeRating = 0;

        //학점의 총합
        double totalGrade = 0;
        
        for(int i = 0; i<20 ; i++){
            //과목 한 개 입력 값 받기
            String str = sc.nextLine();

            //배열로 나누기
            String[] strArr = (str.split(" "));

            //학점
            double grade = Double.parseDouble(strArr[1]);

            //등급
            String rating = strArr[2];

            switch(rating){
                case "A+": ratingPoint=4.5;break;
                case "A0": ratingPoint=4.0;break;
                case "B+": ratingPoint=3.5;break;
                case "B0": ratingPoint=3.0;break;
                case "C+": ratingPoint=2.5;break;
                case "C0": ratingPoint=2.0;break;
                case "D+": ratingPoint=1.5;break;
                case "D0": ratingPoint=1.0;break;
                case "F": ratingPoint=0.0;break;
                case "P": ratingPoint=-1.0;
            }

            if(ratingPoint != -1.0){
                gradeRating += grade*ratingPoint;
                totalGrade += grade;
            }
        }

        //총 점수
        double result = gradeRating/totalGrade;

        System.out.printf("%.6f", result);
    }
}

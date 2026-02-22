import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 색상 순서를 리스트로 만듭니다. (인덱스가 곧 색깔의 '값'이 됨)
        List<String> colors = Arrays.asList(
            "black", "brown", "red", "orange", "yellow",
            "green", "blue", "violet", "grey", "white"
        );

        // 2. 세 개의 색상을 입력받습니다.
        String first = sc.next();
        String second = sc.next();
        String third = sc.next();

        // 3. 인덱스를 찾아서 값을 구합니다.
        long val1 = colors.indexOf(first);
        long val2 = colors.indexOf(second);
        int multiplier = colors.indexOf(third);

        // 4. 공식 적용: (십의 자리 + 일의 자리) * 10^곱셈값
        // 최대 990억이 나올 수 있으므로 반드시 long 타입을 사용해야 합니다.
        long result = (val1 * 10 + val2);
        
        // 세 번째 색상의 값만큼 10을 곱해줍니다.
        result = (long) (result * Math.pow(10, multiplier));

        System.out.println(result);
    }
}
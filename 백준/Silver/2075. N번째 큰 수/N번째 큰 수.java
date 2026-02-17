import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
/* N큰수 찾기
[상황]
- N*N의 표에 수 N^2이 채워져 있다. 한 가지 특징이 있는데 모든 수는 자신의 한 칸 위에 있는 수보다 크다
- 이러한 상황에서 N큰수를 구하라

[로직]
PriorityQueue를 사용
PriorityQueue란?
- 일반적인 queue와는 다른, 정렬을 해주는 큐라고 생각해주면 된다
- 최상단은 제일 작은 수, 최하단은 제일 높은 수가 들어가고
- poll를 할 시 제일 작은 숫자를 반환


*/
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // N큰수
        int N = sc.nextInt();
        sc.nextLine();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int idx= 0 ;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
            while (st.hasMoreTokens()) {
                pq.offer(Integer.parseInt(st.nextToken()));

                if(pq.size() > N) pq.poll();
            }
        }

        System.out.println(pq.peek());
    }

}
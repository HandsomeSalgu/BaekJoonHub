import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    //컴퓨터의 수
    static int computerNum;

    //컴퓨터가 이어지는 쌍
    static int linkComputerNum;

    // 컴퓨터 연결 리스트
    static List<ArrayList<Integer>> list;

    //방문 확인
    static boolean[] visited;

    //정답 확인
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //컴퓨터의 수
        computerNum = sc.nextInt();

        //컴퓨터가 이어지는 쌍
        linkComputerNum = sc.nextInt();

        //컴퓨터 연결 리스트
        list = new ArrayList<>(computerNum + 1);

        //방문 확인
        visited = new boolean[computerNum+1];

        //컴퓨터의 수 만큼 list 늘려주기
        for (int i = 0; i < computerNum+1; i++) {
            list.add(null);
        }

        //리스트 안에 값 넣어주기
        for (int i = 0; i < linkComputerNum; i++) {
            int idx = sc.nextInt();
            int tmp = sc.nextInt();

            //만약 idx의 요소가 null이면 새로운 ArrayList넣어주고 값 넣어주기
            if(list.get(idx) == null){
                list.set(idx, new ArrayList<>());
            }

            if(list.get(tmp) == null){
                list.set(tmp, new ArrayList<>());
            }

            //값 넣어주기
            list.get(idx).add(tmp);
            list.get(tmp).add(idx);
        }

//        for(int i = 0; i< list.size() ;i++){
//            System.out.print(list.get(i));
//        }
        dfs(1);

        System.out.println(count);

    }

    static void dfs(int idx){

        //방문
        visited[idx] = true;

        //해당 idx가 null이면 return
        if(list.get(idx) == null) return;

        for(int i = 0; i<list.get(idx).size(); i++){

            //만약 현재 idx가 이미 들렸던 곳(true)이면 continue;
            if(visited[list.get(idx).get(i)]) continue;

            //아니면 수 증가하면서 dfs 시작
            count++;
            dfs(list.get(idx).get(i));
        }
    }
}

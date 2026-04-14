import java.util.*;

public class Main {

    //간선을 이용해서 저장
    static class Edge implements Comparable<Edge>{
        int v, cost;

        public Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "v=" + v +
                    ", cost=" + cost +
                    '}';
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //집의 개수 N
        int N = sc.nextInt();
        //길의 개수 M
        int M = sc.nextInt();

        //인접 리스트 만들기
        List<Edge>[] adjList = new ArrayList[N+1];
        for(int i = 1; i<=N ; i++){
            adjList[i] = new ArrayList<>();
        }

        //길 추가
        for(int i = 0; i<M ;i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();

            adjList[from].add(new Edge(to, cost));
            adjList[to].add(new Edge(from, cost));
        }

        /*
        for(int i = 1; i<=N ;i++){
            System.out.println(i + "번째");
            List<Edge> edge = adjList[i];
            for(int j = 0; j<edge.size();j++){
                System.out.println(edge.get(j).toString());
            }
            System.out.println("----------------------");
        }
        */

        //프림 알고리즘 사용
        boolean[] visited = new boolean[N+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        int maxNum = 0;
        int ans = 0;
        int pick = 0;
        pq.add(new Edge(1,-0));

        while(pick < N){
            Edge e = pq.poll();
            if(visited[e.v])
                continue;

            maxNum = Math.max(maxNum, e.cost);
            ans += e.cost;
            visited[e.v] = true;
            pick++;

            pq.addAll(adjList[e.v]);
        }

        System.out.println(ans - maxNum);
    }
}
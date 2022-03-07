package w6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q4 {
    private static int[] adj;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // 레벨을 알아야 한다 : BFS
        // 무방향
        // 친구 없는 사람은 없고, 모든 사람은 친구로 연결도어 있다.
        // 1부터 N까지이므로 -1을 하든지 크기 +1을 해야 한다.
        // 유저수 친구관계수 (정점 간선)
        // 관계
        // 일차원 배열로도 충분
        // bfs(시작점, 목표) : level을 리턴하도록 만들자
        // 1,2 1,3 1,4 1,5 1,6 ... 이렇게 돌고 더해서 min 비교
        // 2,1 2,3 2,4 2,5 2,6 ... min 비교
        // min이 같은 경우 번호가 작은 사람 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        adj = new int[v];
        visited = new boolean[v];

        for(int i = 0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken()) - 1;
            int vertex2 = Integer.parseInt(st.nextToken()) - 1;
            adj[vertex1] = vertex2;
        }

        int[] min = new int[v];
        for(int i = 0; i<v; i++) {
            int kevin = 0;
            for(int j = 0; j<v; j++) {
                kevin += bfs(i, j);
            }
            min[i] = kevin;
        }

        int answer = v;
        for(int i = 0; i<min.length - 1; i++) {
            if (min[i] <= min[i+1]) {
                answer = i;
            }
            else if (min[i] > min[i+1]) {
                answer = i+1;
            }
        }
        System.out.println(answer);
    }

    public static int bfs(int x, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;

        int level = 0;
        while(!queue.isEmpty()) {
            int current = queue.poll();
            int next = adj[current];
            if(next == target) {
                break;
            }
            if(!visited[next]) {
                visited[next] = true;
                queue.add(next);
            }
        }
        level++;

        return level;
    }
}

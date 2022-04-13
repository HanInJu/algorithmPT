package pt.w7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q3 {
    private static int[] dx = new int[2];
    private static int[] adj;
    private static boolean[] visited;
    private static int F, S, G;
    private static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        dx[0] = Integer.parseInt(st.nextToken());
        dx[1] = -Integer.parseInt(st.nextToken());

        adj = new int[F+1];
        visited = new boolean[F+1];

        for(int i = 0; i<=F; i++) {
            adj[i] = INF;
        }
        adj[S] = 0;

        bfs(S);

        if(visited[G]) {
            System.out.println(adj[G]);
        }
        else {
            System.out.println("use the stairs");
        }
    }

    public static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if(cur == G) {
                break;
            }

            for(int i = 0; i<2; i++) {
                int nx = cur + dx[i];

                if(1<=nx && nx<=F && !visited[nx]) {
                    queue.add(nx);
                    visited[nx] = true;
                    adj[nx] = adj[cur] + 1;
                }
            }
        }
    }
}

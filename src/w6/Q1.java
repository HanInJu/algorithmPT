package w6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Q1 {
    private static TreeSet<Integer>[] adj;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        adj = new TreeSet[v+1];
        initList(adj);
        visited = new boolean[v+1];
        int vertex1, vertex2;

        for(int i = 0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            vertex1 = Integer.parseInt(st.nextToken());
            vertex2 = Integer.parseInt(st.nextToken());
            adj[vertex1].add(vertex2);
            adj[vertex2].add(vertex1);
        }

        dfs(start);
        initVisited(visited);
        System.out.println();
        bfs(start);
    }

    public static void dfs(int x) {
        visited[x] = true;
        System.out.print(x + " ");
        for(int next : adj[x]) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            for(int next : adj[now]) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }

    public static void initList(TreeSet<Integer>[] adj) {
        for(int i = 0; i<adj.length; i++) {
            adj[i] = new TreeSet<>();
        }
    }

    public static void initVisited(boolean[] visited) {
        Arrays.fill(visited, false);
    }

}

package pt.w7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1 {
    private static LinkedList<Integer>[] adj;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        adj = new LinkedList[n];
        visited = new boolean[n];

        for(int i = 0; i<n; i++) {
            adj[i] = new LinkedList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start =  Integer.parseInt(st.nextToken()) - 1;
        int target =  Integer.parseInt(st.nextToken()) - 1;

        int e = Integer.parseInt(br.readLine());
        for(int i = 0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken()) - 1;
            int child = Integer.parseInt(st.nextToken()) - 1;
            adj[parent].add(child);
            adj[child].add(parent);
        }

        int level = bfs(start, target);
        if(!visited[target]) {
            System.out.println(-1);
        }
        else {
            System.out.println(level);
        }
    }

    public static int bfs(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        int level = 0;
        while(!queue.isEmpty()) {
            int qSize = queue.size();
            for(int i = 0; i<qSize; i++) {
                int current = queue.poll();

                for(int next : adj[current]) {
                    if(!visited[next]) {
                        visited[next] = true;
                        if(current == target) {
                            break;
                        }
                        queue.add(next);
                    }
                }
            }
            level++;
        }

        return level;
    }
}

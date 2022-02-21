package w5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q3 { // https://www.acmicpc.net/problem/11724
    private static LinkedList<Integer>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // 무방향그래프
        // 컴포넌트의 개수를 센다. = dfs의 개수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        graph = new LinkedList[vertex+1];
        visited = new boolean[vertex+1];

        for(int i = 0; i<= vertex; i++) {
            graph[i] = new LinkedList<>();
        }

        for(int i = 0; i<edge; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        int n = 0;
        for(int i = 1; i<= vertex; i++) {
            if(!visited[i]) {
                dfs(i);
                n++;
            }
        }

        System.out.println(n);
    }

    public static void dfs(int x) {
        visited[x] = true;
        for(int a : graph[x]) {
            if(!visited[a]) {
                dfs(a);
            }
        }
    }
}

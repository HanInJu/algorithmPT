package pt.w6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q7 {
    private static int[][] adj;
    private static boolean[][] visited;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int n;

    public static void main(String[] args) throws IOException {
        // dfs 컴포넌트의 개수, 컴포넌트 내 노드의 개수
        // st 못 씀 (다 붙어있음 charAt)
        // 이차원배열 세팅 -> 1인 곳부터 dfs 돌고 -> dfs 횟수 세기 + 노드 수 세기
        // Arrays.sort()로 정렬
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        adj = new int[n][n];
        visited = new boolean[n][n];

        String line;
        int number = 0;
        int[] components = new int[n*n];

        for(int i = 0; i<n; i++) {
            line = br.readLine();
            for(int j = 0; j<n; j++) {
                adj[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                if(adj[i][j] == 1 && !visited[i][j]) {
                    components[number] = dfs(i,j);
                    number++;
                }
            }
        }

        System.out.println(number);
        Arrays.sort(components);
        for(int nodes : components) {
            if(nodes > 0) {
                System.out.println(nodes);
            }
        }
    }

    public static int dfs(int x, int y) {
        int nodes = 1;
        visited[x][y] = true;
        for(int i = 0; i<dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(inRange(nx, ny) && !visited[nx][ny] && adj[nx][ny] == 1) {
                nodes += dfs(nx, ny);
            }
        }
        return nodes;
    }

    public static boolean inRange(int x, int y) {
        return 0<=x && x<n && 0<=y && y<n;
    }
}

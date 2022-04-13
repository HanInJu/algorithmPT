package pt.w5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1 { // https://www.acmicpc.net/problem/1012
    private static boolean[][] visited;
    private static int[][] ground;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int worm;
    private static int m, n;

    public static void main(String[] args) throws IOException {
        // 방향 그래프
        // 인접행렬 방식
        // 행렬에 넣고
        // 반복 돌면서 dfs
        // dfs의 횟수를 구한다.
        // visited, 배추 개수, 행렬, dfs 변수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i<testCase; i++) {
            worm = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int vegetable = Integer.parseInt(st.nextToken());

            visited = new boolean[m][n];
            ground = new int[m][n];
            for(int j = 0; j<vegetable; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                ground[x][y] = 1;
            }

            for(int x = 0; x<m; x++) {
                for(int y = 0; y<n; y++) {
                    if(!visited[x][y] && ground[x][y] == 1) {
                        dfs(x,y);
                        worm++;
                    }
                }
            }

            System.out.println(worm);
        }

    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        for(int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(isInBound(nx,ny) && !visited[nx][ny] && ground[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }

    public static boolean isInBound(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}

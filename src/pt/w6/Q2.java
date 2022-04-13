package pt.w6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2 {
    private static int[][] adj;
    private static boolean[][] visited;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int n;

    public static void main(String[] args) throws IOException {
        // 인접행렬
        // 높이별로 검사해야 함
        // 비가 적게 올 때가 답이 아닌 이유 : 영역의 개수를 알아야 하기 때문
        // 높이는 1 이상 100 이하 N도 2이상 100이하
        // 인접행렬 만들고 dfs를 강수량 별로 돌면서 높이가 그 이상인 컴포넌트의 개수를 체크, 최대 개수 구하기
        // 방향그래프
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        adj = new int[n][n];
        StringTokenizer st;
        int maxHeight = 0;

        for(int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++) {
                int height = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, height);
                adj[i][j] = height;
            }
        }

        int max = 0;
        int height = 0;

        for(int h = height; h <= maxHeight; h++) {
            visited = new boolean[n][n];
            int component = 0;

            for(int i = 0; i<n; i++) {
                for(int j = 0; j<n; j++) {
                    if(!visited[i][j] && adj[i][j] > h) {
                        dfs(i, j, h);
                        component++;
                    }
                }
            }

            max = Math.max(max, component);
        }

        System.out.println(max);

    }

    public static void dfs(int x, int y, int height) {
        visited[x][y] = true;
        for(int i = 0; i<dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(inRange(nx, ny) && !visited[nx][ny] && adj[nx][ny] > height) {
                dfs(nx, ny, height);
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}

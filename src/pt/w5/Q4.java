package pt.w5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q4 { // https://www.acmicpc.net/problem/1743
    private static int[][] ground;
    private static boolean[][] visited;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int n,m;

    public static void main(String[] args) throws IOException {
        // dfs 각 컴포넌트의 크기를 알아야 한다.
        // 방향 그래프
        // 최대 크기가 100이므로 이차원배열을 사용한다.
        // 음식물 크기 priorityQueue reverse을 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> trash = new PriorityQueue<>(Comparator.reverseOrder());
        ground = new int[m][n];
        visited = new boolean[m][n];

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            ground[x][y] = 1;
        }

        for(int x = 0; x<m; x++) {
            for(int y = 0; y<n; y++) {
                if(!visited[x][y] && ground[x][y] == 1) {
                    int size = dfs(x,y);
                    trash.add(size);
                }
            }
        }

        System.out.println(trash.poll());
    }

    public static int dfs(int x, int y) {
        int node = 1;
        visited[x][y] = true;
        for(int i = 0; i<dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isInBound(nx, ny) && !visited[nx][ny] && ground[nx][ny] == 1) {
                node += dfs(nx, ny);
            }
        }

        return node;
    }

    public static boolean isInBound(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}

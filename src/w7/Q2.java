package w7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2 {
    private static int[][] adj;
    private static boolean[][] visited;
    private static int[] dx = {-2, 2, -1, 1, -2, 2, -1, 1};
    private static int[] dy = {1, 1, 2, 2, -1, -1, -2, -2};
    private static int n, x, y, tx, ty;
    private static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int t = 0; t<testCase; t++) {
            n = Integer.parseInt(br.readLine());
            adj = new int[n][n];
            visited = new boolean[n][n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            tx = Integer.parseInt(st.nextToken());
            ty = Integer.parseInt(st.nextToken());

            for(int i = 0; i<n; i++) {
                for(int j = 0; j<n; j++) {
                    adj[i][j] = INF;
                }
            }
            adj[x][y] = 0;

            bfs(x,y);
            System.out.println(adj[tx][ty]);
        }

    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x,y));
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Point cur = queue.poll();
            if(cur.x == tx && cur.y == ty) {
                break;
            }

            for(int i = 0; i<8; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(inRange(nx, ny) && !visited[nx][ny]) {
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                    adj[nx][ny] = adj[cur.x][cur.y] + 1;
                }
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return 0<=x && x<n && 0<=y && y<n;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

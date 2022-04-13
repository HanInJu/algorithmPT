package pt.w6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q8 {
    private static int[][] adj;
    private static boolean[][] visited;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int n, m;

    public static void main(String[] args) throws IOException {
        // n m
        // st 못씀
        // (n,m)까지 가는 최단거리
        // bfs : level 알아내기 (level은 처음에 1에서 출발)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adj = new int[n][m];
        visited = new boolean[n][m];

        String line;
        for(int i = 0; i<n; i++) {
            line = br.readLine();
            for(int j = 0; j<m; j++) {
                adj[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }
        bfs(0, 0);
        System.out.println(adj[n-1][m-1]);
    }

    public static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new Point(x,y));

        while(!queue.isEmpty()) {
            Point current = queue.poll();
            for(int j = 0; j<dx.length; j++) {
                int nx = current.x + dx[j];
                int ny = current.y + dy[j];
                if(inRange(nx, ny) && !visited[nx][ny] && adj[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                    adj[nx][ny] = adj[current.x][current.y] + 1;
                }
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return 0<=x && x<n && 0<=y && y<m;
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

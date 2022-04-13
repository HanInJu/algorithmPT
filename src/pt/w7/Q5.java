package pt.w7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q5 {
    private static int w, h, INF = 987654321, x, y;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] adj;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for(int t = 0; t<test; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            adj = new int[h][w];
            visited = new boolean[h][w];

            String line;
            for(int i = 0; i<h; i++) {
                line = br.readLine();
                for(int j = 0; j<w; j++) {
                    char ch = line.charAt(j);
                    if(ch == '#') {
                        adj[i][j] = -1;
                    }
                    else if(ch == '@') {
                        adj[i][j] = 0;
                        x = i;
                        y = j;
                    }
                    else if(ch == '*') {
                        adj[i][j] = -9;
                    }
                    else {
                        adj[i][j] = INF;
                    }
                }
            }

            bfs(x,y);

        }

    }

    public static boolean bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Point cur = queue.poll();
            if(cur.x == 0 || cur.y == 0) {
                return true;
            }

            int fireX = 0, fireY = 0;
            for(int i = 0; i<h; i++) {
                for(int j = 0; j<w; j++) {
                    if(adj[i][j] == -1) {
                        fireX = i;
                        fireY = j;
                        break;
                    }
                }
                break;
            }
            fireBfs(fireX, fireY);
        }

        return false;
    }

    public static void fireBfs(int x, int y) {
        for(int i = 0; i<h; i++) {
            for(int j = 0; j<w; j++) {
                if(adj[i][j] == -1) {

                }
            }
        }
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

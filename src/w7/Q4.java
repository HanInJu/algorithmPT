package w7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q4 {
    private static int L = -1, R = -1, C = -1, cx, cy, cz, tx,ty,tz;
    private static int INF = 987654321;
    private static int[][][] adj;
    private static boolean[][][] visited;
    private static int[] dx = {-1, 0, 1, 0, 0, 0};
    private static int[] dy = {0, 1, 0, -1, 0, 0};
    private static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if(!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if(L==0 && R==0 && C==0) {
                break;
            }

            adj = new int[L][R][C];
            visited = new boolean[L][R][C];

            for(int l=0; l<L; l++) {
                for(int r=0; r<R; r++) {
                    String str = br.readLine();
                    if(str.equals("")) {
                        str = br.readLine();
                    }

                    for(int c=0; c<C; c++) {
                        char ch = str.charAt(c);
                        if(ch == 'S') {
                            cx = l;
                            cy = r;
                            cz = c;
                            adj[l][r][c] = 0;
                        }
                        else if(ch == 'E') {
                            tx = l;
                            ty = r;
                            tz = c;
                            adj[l][r][c] = 0;
                        }
                        else if(ch == '.') {
                            adj[l][r][c] = INF;
                        }
                        else {
                            adj[l][r][c] = -1;
                        }
                    }
                }
            }

            bfs(cx, cy, cz);
            if(visited[tx][ty][tz]) {
                System.out.println("Escaped in " + adj[tx][ty][tz] + " minute(s).");
            }
            else {
                System.out.println("Trapped!");
            }
        }
    }

    private static void bfs(int z, int y, int x) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(z, y, x));
        visited[z][y][x] = true;

        while(!queue.isEmpty()) {
            Point cur = queue.poll();
            if(cur.x == tx && cur.y == ty && cur.z == tx) {
                break;
            }

            for(int i = 0; i<6; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nz = cur.z + dz[i];

                if(inRange(nx, ny, nz) && !visited[nx][ny][nz] && adj[nx][ny][nz] != -1) {
                    queue.add(new Point(nx, ny, nz));
                    visited[nx][ny][nz] = true;
                    adj[nx][ny][nz] = adj[cur.x][cur.y][cur.z] + 1;
                }
            }
        }
    }

    private static boolean inRange(int x, int y, int z) {
        return 0<=x && x<L && 0<=y && y<R && 0<=z && z<C;
    }

    static class Point {
        int x;
        int y;
        int z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}

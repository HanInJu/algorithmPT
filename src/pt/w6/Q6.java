package pt.w6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q6 {
    private static int[][] adj;
    private static boolean[][] visited;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int column, row;

    public static void main(String[] args) throws IOException {
        // 가로 세로 (열 행)
        // -1로 초기화(들어있지 않음)
        // 모든 토마토가 익어있으면 0, 며칠이 지나도 익지 못하면 1
        // 익을 때까지의 최소 날짜, 주변부터 계속 퍼져나감 -> bfs
        // 인접한 토마토가 0이면 1로 바꾼다
        // 행렬 세팅
        // 1인 지점을 찾아서 bfs 시작, 인접한 지점 1로 변경 (dx, dy로 nx, ny를 만들어서 adj[nx][ny]가 0이면 1로 만든다)
        // 반복을 모두 돌았으면 day++
        // 새로운 adj로 bfs 시작 (이걸 몇 번 해야 하지?)
        // 토마토가 모두 익지 못하는 상황을 어떻게 판별하지? while 도는 횟수인가?
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        column = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        for(int i = 0; i<row; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<column; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }


    }

    private static int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new Point(x,y));
        int day = 0;

        while(!queue.isEmpty()) {
            Point point = queue.poll();
            for(int i = 0; i<dx.length; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if(inRange(nx, ny) && !visited[nx][ny] && adj[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    adj[nx][ny] = 1;
                    queue.add(new Point(nx, ny));
                }
            }

            day++;
        }

        return day;
    }

    private static boolean inRange(int x, int y) {
        return 0<=x && x<column && 0<=y && y<row;
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

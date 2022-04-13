package pt.w5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Q6 { // https://www.acmicpc.net/problem/2583
    private static int m,n;
    private static int[][] ground;
    private static boolean[][] visited;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        // 아까랑 똑같은 문제
        // 이번에는 0인 곳을 dfs로 구하자
        // 컴포넌트의 개수와 노드 개수를 둘 다 구햏야 함
        // 왼쪽 아래, 오른쪽 위 좌표가 주어지는데
        // (0,2) (4,4)라면 x는 0-3까지 1로 채우고, y는 2-3까지 1로 채워야 하낟.
        // 즉 x1 y1 x2 y2 형태로 들어온다면,
        // x : x1부터 x2-x1+1까지
        // y : y1부터 y2-y1+1까지 1로 채우는 것!
        // 그리고 나서 0인 곳부터 dfs 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ground = new int[m][n];
        visited = new boolean[m][n];

        for(int i = 0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int x = x1; x<(x2-x1); x++) {
                for(int y = y1; y<(y2-y1); y++) {
                    ground[x][y] = 1;
                }
            }
        }
        System.out.println("x");
        TreeSet<Integer> square = new TreeSet<>();
        int answer = 0;
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(!visited[i][j] && ground[i][j] == 0) {
                    square.add(dfs(i,j));
                    answer++;
                }
            }
        }

        System.out.println(answer);
        for(int a : square) {
            System.out.print(a + " ");
        }
    }

    public static int dfs(int x, int y) {
        int node = 1;
        visited[x][y] = true;
        for(int i = 0; i<dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isInBound(nx, ny) && !visited[nx][ny] && ground[nx][ny] == 0) {
                node += dfs(nx, ny);
            }
        }
        return node;
    }

    public static boolean isInBound(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}

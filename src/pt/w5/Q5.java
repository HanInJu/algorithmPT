package pt.w5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Q5 { // https://www.acmicpc.net/problem/2667
    private static int[][] ground;
    private static boolean[][] visited;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int n;

    public static void main(String[] args) throws IOException {
        // 컴포넌트 개수와 노드 개수를 둘 다 세는 문제
        // 컴포넌트 개수 출력 + 노드 개수를 오름차순으로 출력 : 한 줄에 하나씩
        // 정사각형 0111011 이런 데이터로 들어옴
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ground = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i<n; i++) {
            String line = br.readLine();
            char[] charArray = line.toCharArray();
            for(int j = 0; j<n; j++) {
                int value = charArray[j] - '0';
                ground[i][j] = value;
            }
        }

        int answer = 0;
        TreeSet<Integer> home = new TreeSet<>();
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                if(!visited[i][j] && ground[i][j] == 1) {
                    int size = dfs(i,j);
                    home.add(size);
                    answer++;
                }
            }
        }

        System.out.println(answer);
        for(int a : home) {
            System.out.println(a);
        }
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
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}

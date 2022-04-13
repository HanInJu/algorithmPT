package pt.w5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2 { // https://www.acmicpc.net/problem/9466
    private static int[][] team;
    private static boolean[][] visited;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int student;

    public static void main(String[] args) throws IOException {
        // 방향그래프
        // 어느 프로젝트 팀에도 속하지 않는 학생들의 수
        // dfs 돌 때 내부 노드 개수를 알아야 한다.
        // visited, team, students
        // treeset : 번호정렬 array
        // 0부터 시작할 거니까 하나씩 빼주기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i<testCase; i++) {
            student = Integer.parseInt(br.readLine());
            int teamStudent = 0;
            team = new int[student][student];
            visited = new boolean[student][student];
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j<student; j++) {
                int pair = Integer.parseInt(st.nextToken()) - 1;
                team[j][pair] = 1;
            }

            for(int x = 0; x<student; x++) {
                for(int y = 0; y<student; y++) {
                    if(!visited[x][y] && team[x][y] == 1) {
                        teamStudent += dfs(x,y);
                    }
                }
            }

            System.out.println(student - teamStudent);
        }
    }

    public static int dfs(int x, int y) {
        int node = 1;
        visited[x][y] = true;
        for(int i = 0; i<dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isInBound(nx, ny) && !visited[nx][ny] && team[nx][ny] == 1) {
                node += dfs(nx, ny);
            }
        }
        return node;
    }

    public static boolean isInBound(int x, int y) {
        return x >= 0 && x < student && y >= 0 && y < student;
    }
}

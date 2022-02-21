package w5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Q7 { // https://www.acmicpc.net/problem/10026
    public static char[][] paint;
    public static boolean[][] visited;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static char[] value = {'R', 'G', 'B'};
    public static int row;
    public static char color;

    public static void main(String[] args) throws IOException {
        // 적록색약은 R, G를 같은 영역으로 구분 -> R, B만 있는 것
        // 그렇지 않은 사람은 R, G, B 각각 따로 구분
        // n 개의 줄을 돌면서 그림을 만든다
        // value = r,g,b, rg로 4 번 반복 돌면서 r , g, b, r=g 각 구역의 개수를 구한다.
        // (한 번 더 돌면서 r=g 구간을 구한다.)
        // 적록색약X : r+g+b, 적록색약 : r=g+b
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        row = Integer.parseInt(br.readLine());

        paint = new char[row][row];
        for(int x = 0; x < row; x++) {
            String line = br.readLine();
            for(int y = 0; y < row; y++) {
                paint[x][y] = line.charAt(y);
            }
        }

        TreeSet<Integer>[] area = new TreeSet[4];
        for(int i = 0; i<4; i++) {
            area[i] = new TreeSet<>();
        }

        for(int i = 0; i<3; i++) {
            color = value[i];
            visited = new boolean[row][row];

            for(int x = 0; x < row; x++) {
                for(int y = 0; y < row; y++) {
                    if(!visited[x][y] && paint[x][y] == color) {
                        area[i].add(dfs(x,y, color, ' '));
                    }
                }
            }
        }

        for(int x = 0; x < row; x++) {
            for(int y = 0; y < row; y++) {
                if(!visited[x][y] && (paint[x][y] == 'R' || paint[x][y] == 'G')) {
                    area[3].add(dfs(x,y, 'R', 'G'));
                }
            }
        }

        int notIll = 0, ill = 0;
        for(TreeSet<Integer> a : area) {
            for(int b : a) {
                notIll += b;
            }
        }

        for(int a : area[2]) {
            ill += a;
        }
        for(int a : area[3]) {
            ill += a;
        }

        System.out.println(notIll);
        System.out.println(ill);
    }

    public static int dfs(int x, int y, char color1, char color2) {
        int node = 1;
        visited[x][y] = true;
        for(int i = 0; i<dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(color2 == ' ') {
                if(isInBound(nx, ny) && !visited[nx][ny] && paint[nx][ny] == color1) {
                    node += dfs(nx, ny, color1, color2);
                }
            }
            if(isInBound(nx, ny) && !visited[nx][ny] && (paint[nx][ny] == color1 || paint[nx][ny] == color2)) {
                node += dfs(nx, ny, color1, color2);
            }

        }
        return node;
    }

    public static boolean isInBound(int x, int y) {
        return x>=0 && y>=0 && x<row && y<row;
    }
}

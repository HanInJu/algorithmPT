package pt.w6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReQ4 {
    private static int[][] dist;
    private static int v;
    private static int MAX = 987654321;

    public static void main(String[] args) throws IOException {
        // 친구가 여러명이다. -> 인접행렬? 인접리스트? 모든 사람이 다른 모든 사람으로 가는 경로를 구해야 하므로 행렬로 가야 할 것 같다.
        // 무방향
        // 사람 1부터
        // 유저 관계 (정점 간선)
        // 친구관계
        // 가장 작은 사람의 번호를 출력
        // 행렬 만들기 (자신에서 자신으로 가는건 0으로)
        // dfs를 사람마다 돌아야 함... -> 플로이드 와샬 사용
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        dist = new int[v][v];
        for(int i = 0; i<v; i++) { // 배열 초기화
            for(int j = 0; j<v; j++) {
                dist[i][j] = MAX;
                if(i == j) {
                    dist[i][j] = 0;
                }
            }
        }

        for(int i = 0; i<e; i++) { // 간선 입력
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            dist[x][y] = dist[y][x] = 1;
        }

        for(int k = 0; k<v; k++) { // 거치는 정점
            for(int i = 0; i<v; i++) { // 행
                for(int j = 0; j<v; j++) { // 열
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]); // 최단거리 저장
                }
            }
        }

        int minValue = MAX;
        int index = MAX;
        for(int i = 0; i<v; i++) { // 행의 합(케빈 베이컨의 수) 계산, 최소값 구하기
            int total = sum(i);
            if(total < minValue) {
                minValue = total;
                index = i;
            }
        }

        System.out.println(index + 1);
    }

    public static int sum(int i) {
        int sum = 0;
        for(int j = 0; j<v; j++) {
            sum += dist[i][j];
        }
        return sum;
    }
}

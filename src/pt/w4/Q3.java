package pt.w4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3 { // https://www.acmicpc.net/problem/16562
    private static int[] parent;
    public static void main(String[] args) throws IOException {
        //친구비의 음수값으로 초기화
        //union(친구비 절대값이 작은 쪽으로 합치기)
        //다 한 후에 음수값을 더한 것의 절대값과 준석이가 가진 돈을 비교한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        parent = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) {
            parent[i] = -(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            union((Integer.parseInt(st.nextToken())-1), (Integer.parseInt(st.nextToken())-1));
        }

        int need = 0;
        for(int money : parent) {
            if(money < 0) {
                need += money;
            }
        }

        need = Math.abs(need);
        if(need > k) {
            System.out.println("Oh no");
        }
        else {
            System.out.println(need);
        }
    }

    private static int find(int x) {
        if(parent[x] < 0) {
            return x;
        }
        return find(parent[x]);
    }

    private static void union(int x, int y) { //친구비가 작은 쪽으로 합쳐야 한다.
        x = find(x);
        y = find(y);
        if(x == y) {
            return;
        }

        if(parent[x] < parent[y]) {
            parent[x] = y;
        }
        else {
            parent[y] = x;
        }
    }
}

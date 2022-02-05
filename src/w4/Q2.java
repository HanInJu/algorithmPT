package w4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2 { // https://www.acmicpc.net/problem/1976
    static int[] parent;
    public static void main(String[] args) throws IOException {
        // 먼저 N개의 줄을 돌면서 어떤 도시가 어떤 도시와 연결되어 있는지 정보를 넣는다.
        // 지금 자기의 배열 원소값이 -N인 경우 1로 자신과 연결된 노드들을 자신을 루트로 하게끔 배열에 알맞은 값을 넣는다.
        // 넣는 과정에서
        // 자기의 원소값이 -N이 아닌 경우 1. 지금 있는 원소값과 내가 지금 읽은 1인 인덱스를 비교, 같으면 걍 넘어가
        // 2. 다르면 자기를 부모로 하게끔 만든다.
        // 여행계획집합과 같은 집합인지 비교한다. (두 도시씩 끊어서 루트가 같은지 비교, 나온 루트와 다음 도시 하나 비교하다가 같지 않으면 NO)
        // 200, 1000인데 1000이 한쪽으로만 쏠려서 달릴 가능성도 있다.
        // 크기를 고려해가면서 바꿀까?
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n];
        for(int p : parent) {
            p = -n;
        }

        StringTokenizer st;
        for(int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++) {
                String isConnected = st.nextToken();
                if(isConnected.equals("1")) {
                    union(i,j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        String city = st.nextToken();
        int root = find(Integer.parseInt(city));
        for(int i = 0; i<m-1; i++) {
            city = st.nextToken();
            if(root != find((Integer.parseInt(city) - 1))) {
                System.out.println("NO");
                break;
            }
        }
        System.out.println("YES");
    }

    private static int find(int x) {
        if(parent[x] < 0) {
            return x;
        }
        //parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) {
            return;
        }
        if(parent[x] > parent[y]) {
            parent[x] += parent[y];
            parent[y] = x;
        }
        else {
            parent[y] += parent[x];
            parent[x] = y;
        }
    }
}

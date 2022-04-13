package pt.w4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q4 { // https://www.acmicpc.net/problem/4195
    private static HashMap<String, Integer>[] parent;
    public static void main(String[] args) throws IOException {
        // 크기로 초기화해야 한다.
        // 배열 크기는 친구관계 F*2로 설정한다. 초기값 -F*2
        // 나올 때마다 union 하면 되는데, 몇 번 친구가 몇 번 인덱스인지 중요할까?
        // 이름이 중요하다. key, value로 가야한다 => 해시맵 배열을 쓰자
        // 극단의 경우가 나올 가능성이 크다 => 바꿔줘야 한다.
        // 친구 네트워크에 있는 수를 구하려면 루트에 있는 값의 절대값을 리턴하면 된다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for(int i = 0; i<test; i++) {
            int f = Integer.parseInt(br.readLine());
            StringTokenizer st;
            parent = new HashMap[f*2];
            for(int j = 0; j<f*2; j++) {
                parent[j] = new HashMap<>();
            }

            for(int j = 0; j<f; j++) {
                st = new StringTokenizer(br.readLine());
                String friend1 = st.nextToken();
                String friend2 = st.nextToken();

                if(parent[j].get(friend1) == null) {
                    parent[j].put(friend1, -(f*2));
                }
                else if(parent[j].get(friend2) == null) {
                    parent[j].put(friend2, -(f*2));
                }
                else {
                    // union(friend1, friend2);
                }
            }
        }
    }
    /* 이 부분에서 find를 조금 변형해야 했다는 걸 깨달음.
    private static String find(String name) {
        if(parent[x] < 0) {
            return x;
        }

    }

    private static void union(String friend1, String friend2) {
        friend1 = find(friend1);
        friend2 = find(friend2); // 그 친구의 이름을 리턴해야 함
        if(friend1.equals(friend2)) {
            return;
        }

    }

    */
}

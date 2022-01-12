package w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q1 { // https://www.acmicpc.net/problem/9375
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<test; i++) {
            int n = Integer.parseInt(br.readLine());
            Map <String, Integer> map = new HashMap<>();
            for(int j = 0; j<n; j++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String key = st.nextToken();
                if(map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                }
                else {
                    map.put(key, 1);
                }
            }
            int number = map.size();
            int combination = 1;
            for(String keys : map.keySet()) {

            }
        }
    }

    public int comb(int num, int numOfKind, Map map) {
        int combination = 1;

        // num = 3개 종류만 입을 건데, numOfKind = 5개 종류가 있다고 가정하자
        // 먼저 입을 종류의 개수 결정 : 5C3 : 5!/3!
        int kind = 1;
        for(int i = numOfKind; i>num; i--) {
            kind *= i;
        }
        // 고른 종류 중 입을 옷 결정


        return combination;
    }
}

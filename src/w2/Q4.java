package w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q4 { // https://www.acmicpc.net/problem/14425

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> setA = new HashSet<>(n);
        for(int i = 0; i<n; i++) {
            setA.add(br.readLine());
        }

        int cnt = 0;
        for(int i = 0; i<m; i++) {
            if(setA.contains(br.readLine())) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

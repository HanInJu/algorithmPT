package pt.w1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q6 { // https://www.acmicpc.net/problem/1764

    public static void main(String[] arts) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<String> notListened = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            notListened.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder(m);
        for(int i = 0; i < m; i++) {
            String notSaw = br.readLine();
            if(notListened.contains(notSaw)) {
                sb.append(notSaw + "\n");
            }
        }

        System.out.println(notListened.size());
        System.out.println(sb);

    }
}

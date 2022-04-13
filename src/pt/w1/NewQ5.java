package pt.w1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class NewQ5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>(n*2);
        for(int i = 1; i < n+1; i++) {
            String nameOfPoketmon = br.readLine();
            map.put(String.valueOf(i),nameOfPoketmon);
            map.put(nameOfPoketmon, String.valueOf(i));
        }

        for(int i = 0; i < m; i++) {
            System.out.println(map.get(br.readLine()));
        }
    }
}

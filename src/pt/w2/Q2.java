package pt.w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q2 { // https://www.acmicpc.net/problem/2346

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i < (n+1); i++) {
            map.put(i, Integer.parseInt(st.nextToken()));
        }

        int current = 1;
        int numberOfPaper = map.get(current);
        map.replace(current, 0);

        while(map.size() > 0) {
            if(numberOfPaper > 0) {
                current += numberOfPaper;
                if(current > n) {
                    int cnt = 0;
                    for(int i = (current+1); i <= n; i++) {
                        if(map.get(i) != 0) {
                            cnt++;
                        }
                    }
                    numberOfPaper -= cnt;
                    current = 1;
                    for(int i = current; i<=numberOfPaper; i++) {
                        if(map.get(current) == 0) {
                            i--;
                        }
                        else {
                            numberOfPaper--;
                            map.replace(current, 0);
                        }
                        current++;
                    }
                }
            }
            else {
                current -= numberOfPaper;
            }
            map.replace(current, 0);
        }
    }
}

package pt.w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q5 { // https://www.acmicpc.net/problem/2841

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        Stack[] melody = new Stack[6];
        for(int i = 0; i<6; i++) {
            melody[i] = new Stack<Integer>();
        }

        for(int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int prat = Integer.parseInt(st.nextToken());

            int idx;
            for(int j = 0; j<melody[line-1].size(); j++) {
                if((Integer) melody[line-1].get(j) == prat) {
                    idx = melody[line-1].indexOf(prat);
                }
            }
            idx = -1;

        }
    }
}

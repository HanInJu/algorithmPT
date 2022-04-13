package pt.w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q3 { // https://www.acmicpc.net/problem/5397

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] testCase = new String[n];
        for(int i = 0; i<n; i++) {
            testCase[i] = br.readLine();
        }

        int cur = 0, k = 0;
        List<Character> password = new ArrayList<>();
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<testCase[i].length(); i++) {
                switch(testCase[i].charAt(j)) {
                    case '<':
                        if(cur != 0) {

                        }
                    case '>':

                    case'-':
                        if((0 < cur) && (cur <= k)) {
                            password.remove(--cur);
                        }

                        continue;
                    default:
                        k++;
                        password.add(cur, testCase[i].charAt(j));
                }
            }
        }
    }
}

package pt.w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Q3 { // https://www.acmicpc.net/problem/4358
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new TreeMap<>();
        String input = "";
        int n = 0;

        while(true) {
            input = br.readLine();

            if(input == null || input.length() == 0) { // equals("")
                break;
            }

            if(map.containsValue(input)) {
                map.put(input, map.get(input) + 1);
            }
            else {
                map.put(input, 1);
            }
            n++;
        }

        for(String tree : map.keySet()) {
            double prop = (double) map.get(tree) / n * 100;
            System.out.printf("%.4f", prop);
            System.out.println();
        }
    }
}

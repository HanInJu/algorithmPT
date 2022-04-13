package pt.w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Q7 { // https://www.acmicpc.net/problem/11279

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i = 0; i<n; i++) {
            int arg = Integer.parseInt(br.readLine());

            if(arg == 0) {
                if(treeSet.isEmpty()) {
                    System.out.println("0");
                }
                else {
                    int last = treeSet.last();
                    treeSet.remove(last);
                    System.out.println(last);
                }
            }
            else {
                treeSet.add(arg);
            }
        }
    }
}

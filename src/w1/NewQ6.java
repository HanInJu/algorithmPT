package w1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class NewQ6 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        TreeSet<String> treeSet = new TreeSet<>();
        for(int i = 0; i < n; i++) {
            treeSet.add(br.readLine());
        }

        TreeSet<String> answerSet = new TreeSet<>();
        for(int i = 0; i < m; i++) {
            String noSaw = br.readLine();
            if(treeSet.contains(noSaw)) {
                answerSet.add(noSaw);
            }
        }

        System.out.println(answerSet.size());
        for(String name : answerSet) {
            System.out.println(name);
        }
    }
}

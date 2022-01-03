package w1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class NewQ7 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        TreeSet<Integer> aSet = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<a; i++) {
            aSet.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<b; i++) {
            int elementOfB = Integer.parseInt(st.nextToken());
            if(aSet.contains(elementOfB)) {
                aSet.remove(elementOfB);
            }
        }

        if(aSet.size() == 0) {
            System.out.println(aSet.size());
        }
        else {
            System.out.println(aSet.size());
            for (int num : aSet) {
                System.out.print(num + " ");
            }
        }
    }
}

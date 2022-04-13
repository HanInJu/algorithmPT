package pt.w1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q4 { // https://www.acmicpc.net/problem/1302
    public int total;
    public Map<String, Integer> map;
    public String[] titles;
    public String[] topSoldBook;

    public Q4(int num) {
        total = num;
        map = new HashMap<>(total);
        titles = new String[total];
        topSoldBook = new String[total];
    }

    public String topSeller(Scanner sc) {
        int cnt = 0;
        while(sc.hasNextLine()) {
            String title = sc.nextLine();
            if(map.containsKey(title)) {
                map.put(title, map.get(title) + 1);
            }
            else {
                map.put(title, 1);
                titles[cnt++] = title;
            }
        }

        cnt = 0;

        for(int i = 0; i<map.size() - 1; i++) {
            if(map.get(titles[i]) > map.get(titles[i+1])) {
                topSoldBook[cnt++] = titles[i];
            }
            else {
                topSoldBook[cnt++] = titles[i+1];
            }
        }

        Arrays.sort(topSoldBook);
        return topSoldBook[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Q4 q4 = new Q4(num);
        System.out.println(q4.topSeller(sc));
    }
}

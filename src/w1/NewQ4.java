package w1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class NewQ4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        String[] books = new String[n];
        Map<String, Integer> map = new HashMap<>(n);
        for(int i = 0; i < n; i++) {
            String title = br.readLine();
            if(map.containsKey(title)) {
                map.put(title, map.get(title) + 1);
            }
            else {
                map.put(title, 1);
                books[cnt++] = title;
            }
        }

        String answer = "";
        for(int i = 0; i < n-1; i++) {
            if(map.get(books[i]) > map.get(books[i+1])) {
                answer = books[i];
            }
            else if(map.get(books[i]) == map.get(books[i+1])) {
                if(books[i].compareTo(books[i+1]) < 0) {
                    answer = books[i];
                }
            }
            else {
                answer = books[i+1];
            }
        }

        System.out.println(answer);
    }
}

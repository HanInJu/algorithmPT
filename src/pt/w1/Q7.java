package pt.w1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q7 { // https://www.acmicpc.net/problem/1822
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        TreeSet<Integer> listA = new TreeSet<Integer>();
        for(int i = 0; i < a; i++) {
            listA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < b; i++) {
            int number = Integer.parseInt(st.nextToken());
            if(listA.contains(number)) {
                listA.remove((Integer) number);
            }
        }

        if(listA.size() == 0) {
            System.out.println("0");
        }
        else {
            System.out.println(listA.size());
//            NavigableSet<Integer> descendingSet = listA.descendingSet();
//            NavigableSet<Integer> ascendingSet = descendingSet.descendingSet();
            StringBuilder sb = new StringBuilder(a);
            for(int num : listA) {
                sb.append(num + " ");
            }
            System.out.println(sb);
        }

    }
}

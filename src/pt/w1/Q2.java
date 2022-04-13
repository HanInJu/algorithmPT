package pt.w1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2 { // https://www.acmicpc.net/problem/2161

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int cnt = 1;
        List<Integer> list = new ArrayList<>(number*2);
        while(cnt <= number) {
            list.add(cnt++);
        }

        cnt = 0;

        while(true) {
            if(cnt % 2 == 0) {
                list.remove(cnt);
                //list.
                //System.out.print((list[cnt]).toString() + " ");
            }
        }

    }
}

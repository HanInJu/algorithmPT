package pt.w1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q3 { // https://www.acmicpc.net/problem/7785

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<String> enterLog = new ArrayList<>(n);
        while(sc.hasNextLine()) {
            String oneLog = sc.nextLine();
            System.out.println(oneLog);
            String[] splitLog = oneLog.split(" ");

            if(splitLog[1].equals("leave")) {
                enterLog.remove(splitLog[0] + " enter");
            }
            else {
                enterLog.add(oneLog);
            }
        }

        while(!enterLog.isEmpty()) {
            int i = 0;
            String person = enterLog.get(i++);
            String[] splitName = person.split(" ");
            System.out.println(splitName[0]);
        }

    }
}

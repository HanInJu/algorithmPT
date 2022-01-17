package w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Q6 { // https://www.acmicpc.net/problem/5430
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfTest = Integer.parseInt(br.readLine());

        for(int i = 0; i<numOfTest; i++) {
            String arrayOfMethods = br.readLine();
            int lengthOfArray = Integer.parseInt(br.readLine());
            String array = br.readLine();

            if(lengthOfArray == 0 && arrayOfMethods.contains("D")) {
                System.out.println("error");
                continue;
            }

            ArrayList<Character> list = new ArrayList<>();
            for(int j = 0; j<lengthOfArray; j++) {
                if(j%2 != 0) {
                    list.add(array.charAt(j));
                }
            }

            for(int j = 0; j<arrayOfMethods.length(); j++) {
                if(arrayOfMethods.charAt(j) == 'R') {
                    Collections.reverse(list);
                }
                else { // D
                    if(list.isEmpty()) {
                        System.out.println("error");
                        break;
                    }
                    else {
                        list.remove(0);
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for(char a : list) {
                sb.append(a + ",");
            }
            sb.append("]");

            System.out.println(sb);
        }
    }
}

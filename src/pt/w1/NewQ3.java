package pt.w1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NewQ3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<String> person = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            String log = br.readLine();
            String[] splitLog = log.split(" ");
            if(splitLog[1].equals("enter")) {
                person.add(splitLog[0]);
            }
            else {
                person.remove(splitLog[0]);
            }
        }

        for(String name : person) {
            System.out.println(name);
        }
    }
}

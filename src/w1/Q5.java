package w1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q5 { // https://www.acmicpc.net/problem/1620
    private int numOfPoketmon, numOfQuestion;
    private Map<Integer, String> map;
    private String[] answer;

    public Q5(int number, int quiz) {
        numOfPoketmon = number;
        numOfQuestion = quiz;
        map = new HashMap<>(numOfPoketmon);
        answer = new String[numOfQuestion];
    }

    public String[] quiz(BufferedReader br) throws IOException {
        for(int i = 0; i < numOfPoketmon; i++) {
            String poketmon = br.readLine();
            map.put(i+1, poketmon);
        }

        int cnt = 0;
        for(int i = 0; i < numOfQuestion; i++) {
            String quiz = br.readLine();
            if(isNumber(quiz)) { //숫자이면
                int quizNo = Integer.parseInt(quiz);
                //System.out.println(map.get(quizNo));
                answer[cnt++] = map.get(quizNo);
            }
            else {
                for (Integer key : map.keySet()) {
                    String value = map.get(key);
                    if (value.equals(quiz)) {
                        //System.out.println(key);
                        answer[cnt++] = key.toString();
                    }
                }
            }
        }

        return answer;
    }

    public boolean isNumber(String numberString) {
        try {
            Integer.parseInt(numberString);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        String[] numbers = num.split(" ");
        int number = Integer.parseInt(numbers[0]);
        int quiz = Integer.parseInt(numbers[1]);
        System.out.println("");

        Q5 q5 = new Q5(number, quiz);
        String[] answer = q5.quiz(br);
        for(String a : answer) {
            System.out.println(a);
        }
    }
}

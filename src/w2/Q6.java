package w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q6 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numOfCard = Integer.parseInt(st.nextToken());
        int numOfGame = Integer.parseInt(st.nextToken());

        int suCnt = 0, doCnt = 0;

        Deque<Integer> dodoDeq = new ArrayDeque<>();
        Deque<Integer> suDeq = new ArrayDeque<>();
        for(int i = 0; i<numOfCard; i++) {
            st = new StringTokenizer(br.readLine());
            dodoDeq.addFirst(Integer.parseInt(st.nextToken()));
            suDeq.addFirst(Integer.parseInt(st.nextToken()));
        }

        Deque<Integer> dodoGround = new ArrayDeque<>();
        Deque<Integer> suGround = new ArrayDeque<>();
        for(int i = 0; i<numOfGame; i++) {
            int dodo = dodoDeq.pollFirst();
            int su = suDeq.pollFirst();

            dodoGround.addFirst(dodo);
            suGround.addFirst(su);

            if(dodoDeq.size() == 0 && suDeq.size() == 0) {
                doCnt = suCnt;
                break;
            }
            else if(dodoDeq.size() == 0) {
                suCnt = numOfGame + 1;
                break;
            }
            else if(suDeq.size() == 0) {
                doCnt = numOfGame + 1;
                break;
            }

            if(dodo + su == 5) { // 수연이 이김
                suCnt++;
                while(!dodoGround.isEmpty()) {
                    suDeq.addLast(dodoGround.pollFirst());
                }
                while(!suGround.isEmpty()) {
                    suDeq.addLast(suGround.pollFirst());
                }
            }
            else if(dodo == 5 || su == 5) { // 도도가 이김
                doCnt++;
                while(!suGround.isEmpty()) {
                    dodoDeq.addLast(suGround.pollFirst());
                }
                while(!dodoGround.isEmpty()) {
                    dodoDeq.addLast(dodoGround.pollFirst());
                }
            }
        }

        if(doCnt > suCnt) {
            System.out.println("do");
        }
        else if(doCnt == suCnt) {
            System.out.println("dosu");
        }
        else {
            System.out.println("su");
        }
    }
}

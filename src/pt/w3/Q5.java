package pt.w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q5 { // https://www.acmicpc.net/problem/1966

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfTest = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 0; i<numOfTest; i++) {
            st = new StringTokenizer(br.readLine());
            int numOfDocs = Integer.parseInt(st.nextToken());
            int question = Integer.parseInt(st.nextToken());

            Queue<Document> que = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<numOfDocs; j++) {
                que.offer(new Document(j, Integer.parseInt(st.nextToken())));
            }

            int cnt = 1;
            while(!que.isEmpty()) {
                Document doc = que.poll();
                boolean isPossible = true;
                Iterator<Document> iterator = que.iterator();

                while(iterator.hasNext()) {
                    Document nextDoc = iterator.next();
                    if(doc.priority < nextDoc.priority) {
                        isPossible = false;
                        break;
                    }
                }
                if(isPossible == false) {
                    que.add(doc);
                }
                else {
                    if(doc.order == question) {
                        System.out.println(cnt);
                    }
                    else {
                        cnt++;
                    }
                }
            }
        }
    }
}

class Document {
    public int order;
    public int priority;

    public Document(int order, int priority) {
        this.order = order;
        this.priority = priority;
    }
}
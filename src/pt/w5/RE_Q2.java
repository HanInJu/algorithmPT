package pt.w5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RE_Q2 {
	public static int[] team;
	public static boolean[] visited;
	public static boolean[] finished;
	public static int teamStudent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for(int i = 0; i<testCase; i++) {
			teamStudent = 0;
			int student = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			team = new int[student];
			visited = new boolean[student];
			finished = new boolean[student];

			for(int j = 0; j<student; j++) {
				int pair = Integer.parseInt(st.nextToken()) - 1;
				team[j] = pair;
			}

			for(int x = 0; x<student; x++) {
				if(!visited[x]) {
					dfs(x);
				}
			}

			System.out.println(student - teamStudent);
		}
	}

	public static void dfs(int x) {
		visited[x] = true;
		int next = team[x];
		if(!visited[next]) {
			dfs(next);
		}
		if(!finished[next]) {
			teamStudent++;
			for(int i = next; i != x; i = team[i]) {
				teamStudent++;
			}
		}
		finished[x] = true;
	}
}

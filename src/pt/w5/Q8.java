package pt.w5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q8 { // https://www.acmicpc.net/problem/11403
	private static int[][] adj;
	private static int[][] answer;
	private static boolean[] finished;
	private static boolean[] visited;
	private static int vertex;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		vertex = Integer.parseInt(br.readLine());

		adj = new int[vertex][vertex];
		answer = new int[vertex][vertex];
		finished = new boolean[vertex];
		visited = new boolean[vertex];

		StringTokenizer st;
		for(int i = 0; i<vertex; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<vertex; j++) {
				if(Integer.parseInt(st.nextToken()) == 1) {
					// adj[i][j]
				}
			}
		}

		for(int i = 0; i<vertex; i++) {
			init(visited);
			init(finished);
			dfs(i);

			if(finished[i]) {
				answer[i][i] = 1;
			}
			answer[i][i] = 0;

			for(int j = 0; j<vertex; j++) {
				if(visited[j]) {
					answer[i][j] = 1;
				}
			}
		}

		for(int i = 0; i<vertex; i++) {
			for(int j = 0; j<vertex; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void init(boolean[] array) {
		for(boolean a : array) {
			a = false;
		}
	}

	private static void dfs(int x) {
		visited[x] = true;

		//if(visited[adj[x]])
	}
}

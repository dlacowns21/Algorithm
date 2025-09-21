package goldTwice;

import java.io.*;
import java.util.*;

public class Boj_16928_뱀과사다리게임 {
	
	static int N, M;
	static int[] board = new int[101];
	static boolean[] visited = new boolean[101];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= 100; i++) {
			board[i] = i;
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x] = y;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			board[u] = v;
		}
		
		System.out.println(bfs());
	}
	
	static int bfs() {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[]{1, 0});
		visited[1] = true;
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int pos = cur[0];
			int count = cur[1];
			
			if(pos == 100) {
				return count;
			}

			for(int d = 1; d <= 6; d++) {
				int next = pos + d;
				
				if(next > 100) continue;
				
				int finalPos = board[next];

				if(!visited[finalPos]) {
					visited[finalPos] = true;
					que.offer(new int[]{finalPos, count + 1});
				}
			}
		}
		
		return -1;
	}
}
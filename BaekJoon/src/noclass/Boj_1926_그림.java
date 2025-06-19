package noclass;

import java.io.*;
import java.util.*;

public class Boj_1926_그림 {
	
	static int N, M, count, max;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					count++;
					max = Math.max(max, bfs(i, j));
				}
			}
		}
		
		System.out.println(count);
		System.out.println(max);
	}

	public static int bfs(int sr, int sc) {
		Queue<int[]> que = new LinkedList<>();
		visited[sr][sc] = true;
		que.offer(new int[] {sr, sc});
		int width = 1;
		
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			int r = cur[0];
			int c = cur[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (!check(nr, nc)) continue;
				if (visited[nr][nc]) continue;
				if (map[nr][nc] == 1) {
					visited[nr][nc] = true;
					que.offer(new int[] {nr, nc});
					width++;
				}
			}
		}
		return width;
	}

	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}

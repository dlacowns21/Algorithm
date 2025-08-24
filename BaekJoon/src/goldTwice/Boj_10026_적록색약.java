package goldTwice;

import java.io.*;

public class Boj_10026_적록색약 {
	
	static int N, nor, non;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		nor = countAll(false);
		non = countAll(true);
		
		System.out.println(nor + " " + non);
	}
	
	static int countAll(boolean isBlind) {
		visited = new boolean[N][N];
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					dfs(i, j, map[i][j], isBlind);
					count++;
				}
			}
		}
		
		return count;
	}

	static void dfs(int r, int c, char color, boolean isBlind) {
		visited[r][c] = true;
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(!check(nr, nc)) continue;
			if(visited[nr][nc]) continue;
			
			if(sameColor(color, map[nr][nc], isBlind)) {
				dfs(nr, nc, color, isBlind);
			}
		}
	}
	
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
	
	static boolean sameColor(char color1, char color2, boolean isBlind) {
		if(color1 == color2) return true;
		if(isBlind) {
			if((color1 == 'R' && color2 == 'G') || (color1 == 'G' && color2 == 'R')) {
				return true;
			}
		}
		
		return false;
	}
}
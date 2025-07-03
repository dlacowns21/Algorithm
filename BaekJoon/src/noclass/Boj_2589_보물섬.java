package noclass;

import java.io.*;
import java.util.*;

public class Boj_2589_보물섬 {
    
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new char[N][M];
        for(int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        int answer = 0;
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 'L') {
                    answer = Math.max(answer, bfs(i, j));
                }
            }
        }
        
        System.out.println(answer);
    }
    
    static int bfs(int sr, int sc) {
        Queue<int[]> que = new LinkedList<>();
        visited = new boolean[N][M];
        
        que.offer(new int[] {sr, sc, 0});
        visited[sr][sc] = true;
        
        int maxDist = 0;
        
        while(!que.isEmpty()) {
            int[] cur = que.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];
            
            maxDist = Math.max(maxDist, dist);
            
            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if(!check(nr, nc)) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == 'W') continue;
                
                visited[nr][nc] = true;
                que.offer(new int[] {nr, nc, dist + 1});
            }
        }
        
        return maxDist;
    }
    
    public static boolean check(int r, int c) {
    	return r >= 0 && r < N && c >= 0 && c < M;
    }
}

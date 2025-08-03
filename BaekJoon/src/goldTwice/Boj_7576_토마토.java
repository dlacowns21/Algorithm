package goldTwice;

import java.io.*;
import java.util.*;

public class Boj_7576_토마토 {
    
    static int N, M, answer = 0;
    static Queue<int[]> que;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] map;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        que = new LinkedList<int[]>();
        
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) que.offer(new int[] {i, j, 0});
            }
        }
        
        bfs();
        
        if(checkAll()) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }
    
    public static void bfs() {
        while(!que.isEmpty()) {
            int[] cur = que.poll();
            int r = cur[0];
            int c = cur[1];
            int count = cur[2];
            answer = Math.max(answer, count);
            
            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(!check(nr, nc)) continue;
                if(map[nr][nc] != 0) continue; 
                map[nr][nc] = 1;
                que.offer(new int[] {nr, nc, count + 1});
            }
        }
    }
    
    public static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
    
    public static boolean checkAll() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) return false;
            }
        }
        return true;
    }
}
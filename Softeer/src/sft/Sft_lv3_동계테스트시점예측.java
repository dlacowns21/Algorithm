package sft;

import java.io.*;
import java.util.*;

public class Sft_lv3_동계테스트시점예측 {

    static int N, M, time;
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
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            visited = new boolean[N][M];
            bfs(0, 0);
            boolean melt = false;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(map[i][j] == 1) {
                        int count = 0;
                        for(int d = 0; d < 4; d++) {
                            int nr = i + dr[d];
                            int nc = j + dc[d];
                            if(visited[nr][nc]) count++;
                        }
                        if(count >= 2) {
                            map[i][j] = 0;
                            melt = true;
                        }
                    }
                }
            }
            if(!melt) break;
            time++;
        }
        System.out.println(time);
    }

    static void bfs(int sr, int sc) {
        Queue<int[]>que = new LinkedList<>();
        que.offer(new int[] {sr, sc});
        visited[sr][sc] = true;
        while(!que.isEmpty()) {
            int[] cur = que.poll();
            int r = cur[0];
            int c = cur[1];
            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(!check(nr, nc)) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == 0) {
                    que.offer(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }

            }
        }

    }

    static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}

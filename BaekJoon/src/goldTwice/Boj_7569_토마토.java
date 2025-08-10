package goldTwice;

import java.io.*;
import java.util.*;

public class Boj_7569_토마토 {

    static int N, M, H, answer;
    static int[][][] map;
    static int[] dr = {1, 0, -1, 0, 0, 0};
    static int[] dc = {0, 1, 0, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};
    static Queue<int[]> que;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        answer = 0;

        que = new LinkedList<>();

        map = new int[H][N][M];
        for(int k = 0; k < H; k++) {
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++) {
                    map[k][i][j] = Integer.parseInt(st.nextToken());
                    if(map[k][i][j] == 1) que.offer(new int[] {k, i, j, 0});
                }
            }
        }

        while(!que.isEmpty()) {
            int[] cur = que.poll();
            int h = cur[0];
            int r = cur[1];
            int c = cur[2];
            int count = cur[3];
            if(count > answer) answer = count;
            
            for(int d = 0; d < 6; d++) {
                int nh = h + dh[d];
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if(!check(nh, nr, nc)) continue;
                if(map[nh][nr][nc] != 0) continue;
                
                map[nh][nr][nc] = 1;
                que.offer(new int[] {nh, nr, nc, count + 1});
            }
        }

        if(checkAll()) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }

    public static boolean check(int h, int r, int c) {
        return h >= 0 && h < H && r >= 0 && r < N && c >= 0 && c < M;
    }

    public static boolean checkAll() {
        for(int k = 0; k < H; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(map[k][i][j] == 0) return false;
                }
            }
        }
        return true;
    }
}
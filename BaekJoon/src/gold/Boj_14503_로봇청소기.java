package BaekJoon.src.gold;

import java.io.*;
import java.util.*;

public class Boj_14503_로봇청소기 {

    static int N, M, sr, sc, d;
    static int[][] map;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(st.nextToken());
        sc = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int r = sr, c = sc;
        int cleaned = 0;

        while (true) {
            if (map[r][c] == 0) {
                map[r][c] = 2;
                cleaned++;
            }

            boolean hasUnclean = false;
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (map[nr][nc] == 0) {
                    hasUnclean = true;
                    break;
                }
            }

            if (!hasUnclean) {
                int backDir = (d + 2) % 4;
                int brR = r + dr[backDir];
                int brC = c + dc[backDir];

                if (map[brR][brC] == 1) {
                    break;
                } else {
                    r = brR;
                    c = brC;
                    continue;
                }
            } else {
                d = (d + 3) % 4;
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (map[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                }
            }
        }

        System.out.println(cleaned);
    }
}
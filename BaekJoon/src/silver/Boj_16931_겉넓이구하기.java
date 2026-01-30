package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_16931_겉넓이구하기 {

    static int N, M, ans;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans += N * M * 2;


        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                int h = map[r][c];
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    int nh = 0;
                    if (0 <= nr && nr < N && 0 <= nc && nc < M) nh = map[nr][nc];
                    if (h > nh) ans += (h - nh);
                }
            }
        }

        System.out.println(ans);
    }
}

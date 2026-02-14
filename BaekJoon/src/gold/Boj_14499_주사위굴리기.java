package gold;

import java.io.*;
import java.util.*;

public class Boj_14499_주사위굴리기 {

    static int[] dice = new int[6];
    static int[] dr = {0, 0, 0, -1, 1};
    static int[] dc = {0, 1, -1, 0, 0};

    static void roll(int dir) {
        int top = dice[0], bottom = dice[1], north = dice[2], south = dice[3], east = dice[4], west = dice[5];

        if (dir == 1) {
            dice[0] = west;
            dice[1] = east;
            dice[4] = top;
            dice[5] = bottom;
            dice[2] = north;
            dice[3] = south;
        } else if (dir == 2) {
            dice[0] = east;
            dice[1] = west;
            dice[4] = bottom;
            dice[5] = top;
            dice[2] = north;
            dice[3] = south;
        } else if (dir == 3) {
            dice[0] = south;
            dice[1] = north;
            dice[2] = top;
            dice[3] = bottom;
            dice[4] = east;
            dice[5] = west;
        } else {
            dice[0] = north;
            dice[1] = south;
            dice[2] = bottom;
            dice[3] = top;
            dice[4] = east;
            dice[5] = west;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int r = x, c = y;

        for (int i = 0; i < K; i++) {
            int dir = Integer.parseInt(st.nextToken());

            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

            r = nr; c = nc;
            roll(dir);

            if (map[r][c] == 0) {
                map[r][c] = dice[1];
            } else {
                dice[1] = map[r][c];
                map[r][c] = 0;
            }

            sb.append(dice[0]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
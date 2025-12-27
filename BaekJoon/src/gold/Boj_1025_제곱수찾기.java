package BaekJoon.src.gold;

import java.io.*;
import java.util.*;

public class Boj_1025_제곱수찾기 {

    static int N, M;
    static int[][] table;
    static int max = -1;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        table = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                table[i][j] = line.charAt(j) - '0';
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                for (int dr = -N; dr < N; dr++) {
                    for (int dc = -M; dc < M; dc++) {
                        sequence(r, c, dr, dc);
                    }
                }
            }
        }

        System.out.println(max);
    }

    static void sequence(int startR, int startC, int dr, int dc) {
        int num = 0;
        int r = startR;
        int c = startC;

        while (r >= 0 && r < N && c >= 0 && c < M) {
            num = num * 10 + table[r][c];

            if (complete(num)) {
                max = Math.max(max, num);
            }

            if (dr == 0 && dc == 0) {
                break;
            }

            r += dr;
            c += dc;
        }
    }

    static boolean complete(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_1388_바닥장식 {

    static int N, M;
    static char[][] map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int ans = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '-') {
                    if (j == 0 || map[i][j - 1] == '|') ans++;
                } else {
                    if (i == 0 || map[i - 1][j] == '-') ans++;
                }
            }
        }

        System.out.println(ans);
    }
}
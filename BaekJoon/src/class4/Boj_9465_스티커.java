package class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_9465_스티커 {

    static int T, N;
    static int[][] map;
    static int[][] dp;
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            N = Integer.parseInt(br.readLine());
            map = new int[2][N];
            for(int i = 0; i < 2; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp = new int[2][N];
            dp[0][0] = map[0][0];
            dp[1][0] = map[1][0];

            if (N > 1) {
                dp[0][1] = map[0][1] + map[1][0];
                dp[1][1] = map[0][0] + map[1][1];

                for(int i = 2; i < N; i++){
                    dp[0][i] = map[0][i] + Math.max(dp[1][i - 1], dp[1][i - 2]);
                    dp[1][i] = map[1][i] + Math.max(dp[0][i - 1], dp[0][i - 2]);
                }
            }

            System.out.println(Math.max(dp[0][N - 1], dp[1][N - 1]));
        }
    }
}

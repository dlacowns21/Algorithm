package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_1010_다리놓기 {

    static int T, N, M;
    static int[][] dp;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        dp = new int[30][30];

        for(int i = 0; i < 30; i++){
            dp[i][0] = 1;
            dp[i][i] = 1;

            for(int j = 1; j < i; j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            sb.append(dp[M][N]).append("\n");
        }

        System.out.print(sb);
    }
}
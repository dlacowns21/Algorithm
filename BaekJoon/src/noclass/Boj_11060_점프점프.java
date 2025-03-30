package noclass;

import java.io.*;
import java.util.*;

public class Boj_11060_점프점프 {

    static int N;
    static int[] map, dp;

    public static void main(String[] args) throws Exception{
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        map = new int[N];
        
        for(int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        
        dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i = 0; i < N; i++) {
            if(dp[i] == Integer.MAX_VALUE) continue;
            for(int j = 1; j <= map[i]; j++) {
                if(i + j >= N) break;
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }

        if(dp[N - 1] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N - 1]);
        }
    }
}
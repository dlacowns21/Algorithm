package silver;

import java.io.*;
import java.util.*;

public class Boj_1912_연속합 {

    static int N;
    static int[] nums;
    static int[] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
package class4.silver_twice;

import java.io.*;
import java.util.*;

public class Boj_11053_가장긴증가하는부분수열 {
	
	static int N, answer;
	static int[] nums, dp;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		nums = new int[N];
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N];
		for(int i = 0; i < N; i++) {
			dp[i] = 1;
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < i; j++) {
				if(nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.println(answer);

	}

}

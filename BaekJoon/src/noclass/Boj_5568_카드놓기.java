package noclass;

import java.io.*;
import java.util.*;

public class Boj_5568_카드놓기 {
	
	static int n, k;
	static int[] map, nums;
	static boolean[] visited;
	static HashSet<Integer> set = new HashSet<>();

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		map = new int[n];
		nums = new int[n];
		for(int i = 0; i < n; i++) {
			map[i] = Integer.parseInt(br.readLine());
		}
		
		visited = new boolean[n];
		
		perm(0);
		
		System.out.println(set.size());

	}
	
	static void perm(int cnt) {
		if(cnt == k) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < k; i++) {
				sb.append(nums[i]);
			}
			set.add(Integer.parseInt(sb.toString()));
			return;
		}
		for(int i = 0; i < n; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			nums[cnt] = map[i];
			perm(cnt + 1);
			nums[cnt] = 0;
			visited[i] = false;
		}
	}

}

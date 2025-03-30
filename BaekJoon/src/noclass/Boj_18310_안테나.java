package noclass;

import java.io.*;
import java.util.*;

public class Boj_18310_안테나 {
	
	static int N;
	static int[] map;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N];		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(map);
		
		int ans = 0;
		
		if(N % 2 == 1) {
			
			ans = map[N / 2];
			
		} else {
			
			int a = N / 2 - 1;
			int b = a + 1;
			int tempa = 0;
			int tempb = 0;
			
			for(int i = 0; i < N; i++) {
				tempa += Math.abs(map[a] - map[i]);
				tempb += Math.abs(map[b] - map[i]);
			}
			
			if(tempa > tempb) ans = map[b];
			else ans = map[a];
		}
		
		System.out.println(ans);

	}

}

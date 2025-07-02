package noclass;

import java.io.*;
import java.util.*;

public class Boj_17179_케이크자르기 {
	
	static int N, M, L;
	static int[] c;
	static int[] q;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		c = new int[M + 1];
		for (int i = 0; i < M; i++) {
			c[i] = Integer.parseInt(br.readLine());
		}
		c[M] = L;

		q = new int[N];
		for (int i = 0; i < N; i++) {
			q[i] = Integer.parseInt(br.readLine());
		}
		
		StringBuilder sb = new StringBuilder();
		for (int q : q) {
			sb.append(bs(q)).append("\n");
		}
		System.out.print(sb);
	}

	static int bs(int q) {
		int left = 1;
		int right = L;
		int answer = 0;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (check(mid, q)) {
				answer = mid;
				left = mid + 1; 
			} else {
				right = mid - 1;
			}
		}
		return answer;
	}

	static boolean check(int min, int q) {
		int count = 0;
		int last = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] - last >= min) {
				count++;
				last = c[i];
			}
		}
		return count >= q + 1;
	}
}

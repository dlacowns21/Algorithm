package goldTwice;

import java.io.*;
import java.util.*;

public class Boj_1074_Z {
	
	static int N, r, c, answer;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int size = (int) Math.pow(2, N);
		answer = 0;
		
		find(0, 0, size, 0);
		
		System.out.println(answer);
		
	}
	
	public static void find(int x, int y, int size, int count) {
		
		if(size == 1) {
			answer = count;
			return;
		}
		
		int nextSize = size / 2;
		int area = nextSize * nextSize;
		
		if(r < x + nextSize && c < y + nextSize) {
			find(x, y, nextSize, count);
		} else if (r < x + nextSize && c >= y + nextSize) {
			find(x, y + nextSize, nextSize, count + area);
		} else if (r >= x + nextSize && c < y + nextSize) {
			find(x + nextSize, y, nextSize, count + area * 2);
		} else {
			find(x + nextSize, y + nextSize, nextSize, count + area * 3);
		}
	}

}

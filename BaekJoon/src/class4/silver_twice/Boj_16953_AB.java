package class4.silver_twice;

import java.io.*;
import java.util.*;

public class Boj_16953_AB {
	
	static int A, B, count;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		System.out.println(solve());
		
		
	}
	
	public static int solve() {
		count = 1;
		
		while(B != A) {
			
			if(B < A) {
				return -1;
			}
			
			if(B % 2 == 0) {
				B /= 2;
			} else if( B % 10 == 1) {
				B /= 10;
			} else {
				return -1;
			}
			
			count++;
		}
		
		return count;
		
	}

}

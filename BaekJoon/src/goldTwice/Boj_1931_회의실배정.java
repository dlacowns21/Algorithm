package goldTwice;

import java.io.*;
import java.util.*;

public class Boj_1931_회의실배정 {
	
	static int N, count, endTime;
	static int[][] cons;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		cons = new int[N][2];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cons[i][0] = Integer.parseInt(st.nextToken());
			cons[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(cons, (o1, o2) -> {
		    if(o1[1] == o2[1]) {
		        return o1[0] - o2[0];
		    }
		    return o1[1] - o2[1];
		});
		
		for(int i = 0; i < N; i++) {
			if(cons[i][0] >= endTime) {
				count++;
				endTime = cons[i][1];
			}
		}
		
		System.out.println(count);
	}

}

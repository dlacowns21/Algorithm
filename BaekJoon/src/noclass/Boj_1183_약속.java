package noclass;

import java.util.*;
import java.io.*;

public class Boj_1183_약속 {
	
	static int N, result;
	static int[] d;

	public static void main(String[] args) throws Exception {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        d = new int[N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            d[i] = b - a;
        }
        
        Arrays.sort(d);
        
        if (N % 2 == 1) {
            result = 1;
        } else {
            int m1 = d[N / 2 - 1];
            int m2 = d[N / 2];
            result = m2 - m1 + 1;
        }
        
        System.out.println(result);
    }

}

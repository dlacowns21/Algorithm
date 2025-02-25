package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2609 {
	
	static int A, B;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		System.out.println(gcd(A, B));
		System.out.println(lcm(A, B));

	}

	public static int gcd(int a, int b) {
	    if (b == 0) return a;
	    return gcd(b, a % b);
	}

	public static int lcm(int a, int b) {
	    return (a * b) / gcd(a, b);
	}

}

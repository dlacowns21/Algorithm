package class4;

import java.io.*;
import java.util.*;

public class Boj_13172_sigma {
	
    static final long MOD = 1_000_000_007;
    static int M;
    static long answer;

    static long modInverse(long b) {
        return modPow(b, MOD - 2);
    }

    static long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        answer = 0;

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            long S = Long.parseLong(st.nextToken());

            long inverseN = modInverse(N);
            answer = (answer + S * inverseN % MOD) % MOD;
        }

        System.out.println(answer);
    }
}

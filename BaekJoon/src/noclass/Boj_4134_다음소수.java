package noclass;

import java.io.*;
import java.util.*;

public class Boj_4134_다음소수 {

    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int t = 0; t < T; t++) {
            long N = Long.parseLong(br.readLine());
            if (N <= 1) {
                sb.append(2).append("\n");
                continue;
            }
            while (!isPrime(N)) {
                N++;
            }
            sb.append(N).append("\n");
        }
        
        System.out.println(sb);
    }

    private static boolean isPrime(long num) {
        if (num <= 1) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0) return false;
        long sqrt = (long) Math.sqrt(num);
        for (long i = 3; i <= sqrt; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
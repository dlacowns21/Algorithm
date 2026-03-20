package silver;

import java.io.*;

public class Boj_4948_베르트랑공준 {

    static final int MAX = 123456 * 2;
    static boolean[] isNotPrime = new boolean[MAX + 1];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        precomputePrimes();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int count = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (!isNotPrime[i]) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }

    private static void precomputePrimes() {
        isNotPrime[0] = isNotPrime[1] = true;

        for (int i = 2; i * i <= MAX; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
    }
}
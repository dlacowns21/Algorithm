package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_1024_수열의합 {

    static int N, L;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());


        for (int len = L; len <= 100; len++) {

            long sum = (long) len * (len - 1) / 2;

            if (N < sum) {
                continue;
            }

            if ((N - sum) % len != 0) {
                continue;
            }

            long x = (N - sum) / len;

            for (int i = 0; i < len; i++) {
                sb.append(x + i);
                if (i < len - 1) {
                    sb.append(" ");
                }
            }
            System.out.println(sb);
            return;
        }

        System.out.println(-1);
    }
}
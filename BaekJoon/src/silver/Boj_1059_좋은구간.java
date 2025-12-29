package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_1059_좋은구간 {

    static int L, n;
    static int[] S;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        L = Integer.parseInt(br.readLine());
        S = new int[L];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < L; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            if (S[i] == n) {
                System.out.println(0);
                return;
            }
        }

        Arrays.sort(S);

        int left = 0;
        for (int i = 0; i < L; i++) {
            if (S[i] < n) {
                left = S[i];
            }
        }

        int right = Integer.MAX_VALUE;
        for (int i = 0; i < L; i++) {
            if (S[i] > n) {
                right = S[i];
                break;
            }
        }

        int count = 0;

        for (int A = left + 1; A <= n; A++) {
            for (int B = n; B < right; B++) {
                if (A < B) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
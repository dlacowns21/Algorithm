package BaekJoon.src.gold;

import java.io.*;
import java.util.*;

public class Boj_1062_가르침 {

    static int N, K;
    static int[] words;
    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new int[N];

        if (K < 5) {
            System.out.println(0);
            return;
        }

        if (K == 26) {
            System.out.println(N);
            return;
        }

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            int bitmask = 0;

            for (int j = 0; j < word.length(); j++) {
                int bit = word.charAt(j) - 'a';
                bitmask |= (1 << bit);
            }

            words[i] = bitmask;
        }

        int learned = 0;
        learned |= (1 << ('a' - 'a'));
        learned |= (1 << ('n' - 'a'));
        learned |= (1 << ('t' - 'a'));
        learned |= (1 << ('i' - 'a'));
        learned |= (1 << ('c' - 'a'));

        backtrack(learned, 0, 5);

        System.out.println(max);
    }

    static void backtrack(int learned, int idx, int count) {

        if (count == K) {
            int read = 0;

            for (int word : words) {
                if ((word & learned) == word) {
                    read++;
                }
            }

            max = Math.max(max, read);
            return;
        }

        if (idx == 26) {
            return;
        }

        if ((learned & (1 << idx)) != 0) {
            backtrack(learned, idx + 1, count);
        } else {
            backtrack(learned | (1 << idx), idx + 1, count + 1);
            backtrack(learned, idx + 1, count);
        }
    }
}
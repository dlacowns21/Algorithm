package BaekJoon.src.silver;

import java.io.*;

public class Boj_1213_팰린드롬만들기 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'A']++;
        }

        int oddCount = 0;
        int midIdx = -1;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1) {
                oddCount++;
                midIdx = i;
            }
        }

        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder left = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            int half = cnt[i] / 2;
            for (int j = 0; j < half; j++) {
                left.append((char) ('A' + i));
            }
            cnt[i] -= half * 2;
        }

        String mid = "";
        if (midIdx != -1) {
            mid = String.valueOf((char) ('A' + midIdx));
        }

        StringBuilder right = new StringBuilder(left).reverse();

        System.out.println(left.toString() + mid + right.toString());
    }
}
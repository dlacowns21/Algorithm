package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_1251_단어나누기 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int n = s.length();

        String ans = null;

        for (int i = 1; i <= n - 2; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                String a = new StringBuilder(s.substring(0, i)).reverse().toString();
                String b = new StringBuilder(s.substring(i, j)).reverse().toString();
                String c = new StringBuilder(s.substring(j)).reverse().toString();

                String cand = a + b + c;

                if (ans == null || cand.compareTo(ans) < 0) {
                    ans = cand;
                }
            }
        }

        System.out.println(ans);
    }
}

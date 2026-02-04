package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_1748_수이어쓰기 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        long ans = 0;
        long start = 1;
        int len = 1;

        while (start <= N) {
            long end = start * 10 - 1;
            long last = Math.min(N, end);
            long count = last - start + 1;

            ans += count * len;

            start *= 10;
            len++;
        }

        System.out.println(ans);
    }

}

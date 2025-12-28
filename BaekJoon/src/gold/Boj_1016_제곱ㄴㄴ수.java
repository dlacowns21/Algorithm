package BaekJoon.src.gold;

import java.io.*;
import java.util.*;

public class Boj_1016_제곱ㄴㄴ수 {

    static long min, max;
    static boolean[] notSquare;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        min = Long.parseLong(st.nextToken());
        max = Long.parseLong(st.nextToken());

        notSquare = new boolean[(int)(max - min + 1)];

        long sqrtMax = (long)Math.sqrt(max);

        for (long i = 2; i <= sqrtMax; i++) {

            long square = i * i;

            long start = ((min + square - 1) / square) * square;

            for (long j = start; j <= max; j += square) {
                int index = (int)(j - min);
                notSquare[index] = true;
            }
        }

        int count = 0;
        for (int i = 0; i < notSquare.length; i++) {
            if (!notSquare[i]) {
                count++;
            }
        }

        System.out.println(count);
    }
}
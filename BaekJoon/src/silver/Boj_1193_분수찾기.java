package BaekJoon.src.silver;

import java.io.*;

public class Boj_1193_분수찾기 {

    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int line = 1;
        int count = 0;

        while (count + line < N) {
            count += line;
            line++;
        }

        int idx = N - count;

        int numerator, denominator;

        if (line % 2 == 1) {
            numerator = line - idx + 1;
            denominator = idx;
        } else {
            numerator = idx;
            denominator = line - idx + 1;
        }

        System.out.println(numerator + "/" + denominator);
    }
}
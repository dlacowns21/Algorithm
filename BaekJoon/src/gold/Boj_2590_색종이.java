package BaekJoon.src.gold;

import java.io.*;

public class Boj_2590_색종이 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] a = new int[7];
        for (int i = 1; i <= 6; i++) a[i] = Integer.parseInt(br.readLine());

        int boards = 0;

        boards += a[6];

        boards += a[5];
        a[1] = Math.max(0, a[1] - 11 * a[5]);

        boards += a[4];
        for (int i = 0; i < a[4]; i++) {
            int use2 = Math.min(a[2], 5);
            a[2] -= use2;
            int missing2 = 5 - use2;
            a[1] = Math.max(0, a[1] - 4 * missing2);
        }

        boards += a[3] / 4;
        int rem3 = a[3] % 4;
        if (rem3 > 0) {
            boards++;

            int need2 = 0, need1 = 0;
            if (rem3 == 1) { need2 = 5; need1 = 7; }
            else if (rem3 == 2) { need2 = 3; need1 = 6; }
            else { need2 = 1; need1 = 5; } // rem3 == 3

            int use2 = Math.min(a[2], need2);
            a[2] -= use2;

            int missing2 = need2 - use2;
            int totalNeed1 = need1 + missing2 * 4;

            a[1] = Math.max(0, a[1] - totalNeed1);
        }

        boards += a[2] / 9;
        int rem2 = a[2] % 9;
        if (rem2 > 0) {
            boards++;
            int empty2 = 9 - rem2;
            int need1 = empty2 * 4;
            a[1] = Math.max(0, a[1] - need1);
        }

        boards += (a[1] + 35) / 36;

        System.out.println(boards);
    }
}
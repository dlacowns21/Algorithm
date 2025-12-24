package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_1057_토너먼트 {

    static int N, K, L;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        int round = 1;

        while (true) {

            if ((K + 1) / 2 == (L + 1) / 2) {
                System.out.println(round);
                break;
            }

            K = (K + 1) / 2;
            L = (L + 1) / 2;
            round++;

            if (K > N || L > N) {
                System.out.println(-1);
                break;
            }
        }
    }
}
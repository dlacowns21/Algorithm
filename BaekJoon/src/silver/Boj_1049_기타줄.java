package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_1049_기타줄 {

    static int N, M;
    static int[][] price;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        price = new int[M][2];

        int minPackage = Integer.MAX_VALUE;
        int minSingle = Integer.MAX_VALUE;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            price[i][0] = Integer.parseInt(st.nextToken());
            price[i][1] = Integer.parseInt(st.nextToken());

            minPackage = Math.min(minPackage, price[i][0]);
            minSingle = Math.min(minSingle, price[i][1]);
        }

        int packages = (N + 5) / 6;
        int cost1 = packages * minPackage;

        int cost2 = N * minSingle;

        int fullPackages = N / 6;
        int remaining = N % 6;
        int cost3 = fullPackages * minPackage + remaining * minSingle;

        int min = Math.min(cost1, Math.min(cost2, cost3));

        System.out.println(min);
    }
}
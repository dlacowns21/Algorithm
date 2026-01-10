package BaekJoon.src.gold;

import java.io.*;
import java.util.*;

public class Boj_1041_주사위 {

    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dice = new int[6];
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        if (N == 1) {
            int sum = 0;
            int max = 0;
            for (int i = 0; i < 6; i++) {
                sum += dice[i];
                max = Math.max(max, dice[i]);
            }
            System.out.println(sum - max);
            return;
        }

        int min1 = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            min1 = Math.min(min1, dice[i]);
        }

        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                if ((i == 0 && j == 5) || (i == 1 && j == 4) || (i == 2 && j == 3)) {
                    continue;
                }
                min2 = Math.min(min2, dice[i] + dice[j]);
            }
        }

        int min3 = Integer.MAX_VALUE;

        int[][] corners = {
                {0, 1, 2}, {0, 1, 3}, {0, 2, 4}, {0, 3, 4},
                {5, 1, 2}, {5, 1, 3}, {5, 2, 4}, {5, 3, 4}
        };

        for (int[] corner : corners) {
            int sum = dice[corner[0]] + dice[corner[1]] + dice[corner[2]];
            min3 = Math.min(min3, sum);
        }


        long cnt3 = 4;
        long cnt2 = (long)(N - 2) * 8 + 4;
        long cnt1 = (long)(N - 2) * (N - 2) * 5 + (long)(N - 2) * 4;

        long answer = cnt1 * min1 + cnt2 * min2 + cnt3 * min3;

        System.out.println(answer);
    }
}
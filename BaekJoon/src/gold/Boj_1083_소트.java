package BaekJoon.src.gold;

import java.io.*;
import java.util.*;

public class Boj_1083_소트 {

    static int N, S;
    static int[] nums;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        S = Integer.parseInt(br.readLine());

        for (int i = 0; i < N && S > 0; i++) {
            int maxIdx = i;
            int maxVal = nums[i];

            int range = Math.min(i + S, N - 1);

            for (int j = i + 1; j <= range; j++) {
                if (nums[j] > maxVal) {
                    maxVal = nums[j];
                    maxIdx = j;
                }
            }

            for (int j = maxIdx; j > i; j--) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
                S--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(nums[i]);
            if (i < N - 1) sb.append(" ");
        }
        System.out.println(sb);
    }
}
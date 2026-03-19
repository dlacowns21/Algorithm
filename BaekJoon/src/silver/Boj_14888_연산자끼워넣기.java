package silver;

import java.io.*;
import java.util.*;

public class Boj_14888_연산자끼워넣기 {

    static int N;
    static int[] nums, cal;
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        cal = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cal[i] = Integer.parseInt(st.nextToken());
        }

        dfs(nums[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    static void dfs(int num, int idx) {
        if (idx == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (cal[i] > 0) {

                cal[i]--;

                switch (i) {
                    case 0: dfs(num + nums[idx], idx + 1); break;
                    case 1: dfs(num - nums[idx], idx + 1); break;
                    case 2: dfs(num * nums[idx], idx + 1); break;
                    case 3: dfs(num / nums[idx], idx + 1); break;
                }

                cal[i]++;
            }
        }
    }
}
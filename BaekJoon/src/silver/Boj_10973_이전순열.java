package silver;

import java.io.*;
import java.util.*;

public class Boj_10973_이전순열 {

    static int N;
    static int[] nums;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        if (prev()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(nums[i]).append(" ");
            }
            System.out.println(sb.toString().trim());
        } else {
            System.out.println("-1");
        }
    }

    private static boolean prev() {
        int i = N - 1;

        while (i > 0 && nums[i - 1] <= nums[i]) {
            i--;
        }

        if (i <= 0) return false;

        int j = N - 1;
        while (nums[j] >= nums[i - 1]) {
            j--;
        }

        swap(i - 1, j);

        int k = N - 1;
        while (i < k) {
            swap(i, k);
            i++;
            k--;
        }

        return true;
    }

    private static void swap(int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
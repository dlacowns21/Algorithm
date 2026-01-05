package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_1065_한수 {

    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (find(i)) {
                count++;
            }
        }

        System.out.println(count);
    }

    static boolean find(int num) {
        if (num < 100) {
            return true;
        }

        String str = String.valueOf(num);
        int[] nums = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            nums[i] = str.charAt(i) - '0';
        }

        int diff = nums[1] - nums[0];

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] != diff) {
                return false;
            }
        }

        return true;
    }
}
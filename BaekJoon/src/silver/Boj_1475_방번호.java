package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_1475_방번호 {

    static int[] nums;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        nums = new int[10];
        for(int i = 0; i < line.length(); i++){
            int idx = line.charAt(i) - '0';
            nums[idx]++;
        }

        int max = 0;
        for(int i = 0; i < 10; i++){
            if(i == 6 || i == 9) continue;
            if(nums[i] > max) max = nums[i];
        }

        int temp = (nums[6] + nums[9]) / 2 + (nums[6] + nums[9]) % 2;

        int ans = Math.max(max, temp);

        System.out.println(ans);

    }
}

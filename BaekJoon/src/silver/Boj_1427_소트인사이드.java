package silver;

import java.io.*;
import java.util.*;

public class Boj_1427_소트인사이드 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int[] nums = new int[str.length()];

        for(int i = 0; i < str.length(); i++) {
            nums[i] = str.charAt(i) - '0';
        }

        Arrays.sort(nums);

        StringBuilder sb = new StringBuilder();
        for(int i = nums.length - 1; i >= 0; i--) {
            sb.append(nums[i]);
        }

        System.out.println(sb);
    }
}
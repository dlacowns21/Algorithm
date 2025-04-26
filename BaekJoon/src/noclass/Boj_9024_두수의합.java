package noclass;

import java.io.*;
import java.util.*;

public class Boj_9024_두수의합 {

    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            
            int[] nums = new int[n];
            for(int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(nums);
            
            int left = 0;
            int right = n - 1;
            int minDiff = Integer.MAX_VALUE;
            
            while(left < right) {
                int sum = nums[left] + nums[right];
                int diff = Math.abs(sum - k);
                
                minDiff = Math.min(minDiff, diff);
                
                if(sum < k) {
                    left++;
                } else {
                    right--;
                }
            }

            left = 0;
            right = n - 1;
            int count = 0;
            
            while(left < right) {
                int sum = nums[left] + nums[right];
                int diff = Math.abs(sum - k);
                
                if(diff == minDiff) {
                    count++;
                }
                
                if(sum < k) {
                    left++;
                } else {
                    right--;
                }
            }
            
            sb.append(count).append("\n");
        }
        
        System.out.print(sb);
    }
}
package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_1021_회전하는큐 {

    static int N, M, ans;
    static int[] nums;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            deque.add(i);
        }

        nums = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        ans = 0;

        for(int i = 0; i < M; i++){
            int target = nums[i];
            int targetIdx = 0;
            for(Integer num : deque){
                if(num == target) break;
                targetIdx++;
            }

            int left = targetIdx;
            int right = deque.size() - targetIdx;

            if(left <= right){
                for(int j = 0; j < left; j++){
                    deque.addLast(deque.pollFirst());
                }
                ans += left;
            } else {
                for(int j = 0; j < right; j++){
                    deque.addFirst(deque.pollLast());
                }
                ans += right;
            }

            deque.pollFirst();
        }

        System.out.println(ans);
    }
}
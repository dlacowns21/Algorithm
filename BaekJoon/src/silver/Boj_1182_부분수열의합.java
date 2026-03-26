package silver;

import java.io.*;
import java.util.*;

public class Boj_1182_부분수열의합 {

    static int N, S;
    static int[] nums;
    static int count = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);
        System.out.println(count);
    }

    static void dfs(int idx, int sum, int size) {
        if (idx == N) {
            if (size > 0 && sum == S) count++;
            return;
        }
        dfs(idx + 1, sum + nums[idx], size + 1);
        dfs(idx + 1, sum, size);
    }
}
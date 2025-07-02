package noclass;

import java.io.*;
import java.util.*;

public class Boj_2792_보석상자 {
    
    static int N, M;
    static int[] map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[M];
        
        int max = 0;
        
        for (int i = 0; i < M; i++) {
            map[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, map[i]);
        }

        int left = 1;
        int right = max;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (check(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private static boolean check(int x) {
        long cnt = 0;
        for (int jewel : map) {
            cnt += (jewel + x - 1) / x;
        }
        return cnt <= N;
    }
}

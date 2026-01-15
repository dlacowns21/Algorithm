package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_1268_임시반장정하기 {

    static int N;
    static int[][] nums;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nums = new int[N][5];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 1;
        int maxCnt = -1;

        for (int stud = 0; stud < N; stud++) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (i == stud) continue;
                boolean same = false;
                for (int j = 0; j < 5; j++) {
                    if (nums[i][j] == nums[stud][j]) {
                        same = true;
                        break;
                    }
                }
                if (same) cnt++;
            }
            if (cnt > maxCnt) {
                maxCnt = cnt;
                ans = stud + 1;
            }
        }

        System.out.println(ans);
    }
}
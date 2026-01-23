package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_2167_2차원배열의합 {

    static int N, M, K;
    static int[][] map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        K = Integer.parseInt(br.readLine());
        int[][] nums = new int[K][4];
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++){
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < K; t++){
            int x1 = nums[t][0] - 1;
            int y1 = nums[t][1] - 1;
            int x2 = nums[t][2] - 1;
            int y2 = nums[t][3] - 1;
            int sum = 0;
            for(int i = x1; i <= x2; i++){
                for(int j = y1; j <= y2; j++){
                    sum += map[i][j];
                }
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}

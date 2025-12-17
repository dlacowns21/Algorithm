package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_1015_수열정렬 {

    static int N;
    static int[] A;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[][] pairs = new int[N][2];
        for(int i = 0; i < N; i++){
            pairs[i][0] = A[i];
            pairs[i][1] = i;
        }

        Arrays.sort(pairs, (a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int[] P = new int[N];
        for(int i = 0; i < N; i++){
            int origin = pairs[i][1];
            P[origin] = i;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(P[i]);
            if(i < N - 1) sb.append(" ");
        }
        System.out.println(sb);
    }
}
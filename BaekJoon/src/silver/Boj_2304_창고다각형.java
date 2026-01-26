package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_2304_창고다각형 {

    static int N;
    static int[][] map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(map, Comparator.comparingInt(a -> a[0]));

        int maxHeight = 0;
        int maxIndex = 0;
        for (int i = 0; i < N; i++) {
            if (map[i][1] > maxHeight) {
                maxHeight = map[i][1];
                maxIndex = i;
            }
        }

        int area = 0;

        int leftMax = map[0][1];
        int leftPos = map[0][0];

        for (int i = 1; i <= maxIndex; i++) {
            area += leftMax * (map[i][0] - leftPos);
            leftMax = Math.max(leftMax, map[i][1]);
            leftPos = map[i][0];
        }

        int rightMax = map[N - 1][1];
        int rightPos = map[N - 1][0];

        for (int i = N - 2; i >= maxIndex; i--) {
            area += rightMax * (rightPos - map[i][0]);
            rightMax = Math.max(rightMax, map[i][1]);
            rightPos = map[i][0];
        }

        area += maxHeight;

        System.out.println(area);
    }
}
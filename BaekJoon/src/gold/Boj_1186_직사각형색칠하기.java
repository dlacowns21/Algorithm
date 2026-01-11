package BaekJoon.src.gold;

import java.io.*;
import java.util.*;

public class Boj_1186_직사각형색칠하기 {

    static int N, K;
    static int[][] rect;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        rect = new int[N + 1][4];

        ArrayList<Integer> xsList = new ArrayList<>();
        ArrayList<Integer> ysList = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            rect[i][0] = x1;
            rect[i][1] = y1;
            rect[i][2] = x2;
            rect[i][3] = y2;

            xsList.add(x1);
            xsList.add(x2);
            ysList.add(y1);
            ysList.add(y2);
        }

        int[] xs = uniqueSorted(xsList);
        int[] ys = uniqueSorted(ysList);

        long[] area = new long[N + 1];

        for (int a = 0; a < xs.length - 1; a++) {
            int xL = xs[a];
            int xR = xs[a + 1];
            long dx = (long) xR - xL;
            if (dx == 0) continue;

            for (int b = 0; b < ys.length - 1; b++) {
                int yB = ys[b];
                int yT = ys[b + 1];
                long dy = (long) yT - yB;
                if (dy == 0) continue;

                int top = 0;
                for (int i = 1; i <= N; i++) {
                    int rx1 = rect[i][0], ry1 = rect[i][1], rx2 = rect[i][2], ry2 = rect[i][3];
                    if (xL >= rx1 && xR <= rx2 && yB >= ry1 && yT <= ry2) {
                        top = i;
                    }
                }

                if (top != 0) {
                    area[top] += dx * dy;
                }
            }
        }

        Integer[] ids = new Integer[N];
        for (int i = 0; i < N; i++) ids[i] = i + 1;

        Arrays.sort(ids, (i, j) -> {
            if (area[i] != area[j]) return Long.compare(area[j], area[i]);
            return Integer.compare(i, j);
        });

        int[] chosen = new int[K];
        for (int t = 0; t < K; t++) chosen[t] = ids[t];

        Arrays.sort(chosen);

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < K; t++) {
            if (t > 0) sb.append(' ');
            sb.append(chosen[t]);
        }
        System.out.println(sb);
    }

    private static int[] uniqueSorted(ArrayList<Integer> list) {
        Collections.sort(list);
        ArrayList<Integer> uniq = new ArrayList<>();
        Integer prev = null;
        for (int v : list) {
            if (prev == null || v != prev) uniq.add(v);
            prev = v;
        }
        int[] arr = new int[uniq.size()];
        for (int i = 0; i < uniq.size(); i++) arr[i] = uniq.get(i);
        return arr;
    }
}
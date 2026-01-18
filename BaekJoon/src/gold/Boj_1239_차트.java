package BaekJoon.src.gold;

import java.io.*;
import java.util.*;

public class Boj_1239_차트 {

    static int N;
    static int[] a;
    static boolean[] used;
    static int[] perm;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        a = new int[N];
        used = new boolean[N];
        perm = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());

        dfs(0);

        System.out.println(ans);
    }

    static void dfs(int depth) {
        if (depth == N) {
            ans = Math.max(ans, evaluate(perm));
            return;
        }
        for (int i = 0; i < N; i++) {
            if (used[i]) continue;
            used[i] = true;
            perm[depth] = a[i];
            dfs(depth + 1);
            used[i] = false;
        }
    }

    static int evaluate(int[] p) {
        boolean[] boundary = new boolean[100];

        int sum = 0;
        boundary[0] = true;
        for (int v : p) {
            sum += v;
            boundary[sum % 100] = true;
        }

        int cnt = 0;
        for (int x = 0; x < 100; x++) {
            if (boundary[x] && boundary[(x + 50) % 100]) cnt++;
        }
        return cnt / 2;
    }
}
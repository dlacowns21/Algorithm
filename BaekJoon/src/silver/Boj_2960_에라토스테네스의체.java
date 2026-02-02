package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_2960_에라토스테네스의체 {

    static int N, K, count;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];

        for (int i = 2; i <= N; i++) {
            if (visited[i]) continue;
            for (int x = i; x <= N; x += i) {
                if (visited[x]) continue;
                visited[x] = true;
                count++;
                if (count == K) {
                    System.out.println(x);
                    return;
                }
            }
        }
    }
}
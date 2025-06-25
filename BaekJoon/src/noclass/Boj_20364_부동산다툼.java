package noclass;

import java.io.*;
import java.util.*;

public class Boj_20364_부동산다툼 {

    static int N, Q;
    static boolean[] got;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        got = new boolean[N + 1];

        for (int i = 0; i < Q; i++) {
            int x = Integer.parseInt(br.readLine());
            int temp = x;
            int conflict = 0;

            while (temp >= 1) {
                if (got[temp]) {
                    conflict = temp;
                }
                if (temp == 1) break;
                temp /= 2;
            }

            if (conflict == 0) {
                got[x] = true;
                sb.append(0).append("\n");
            } else {
                sb.append(conflict).append("\n");
            }
        }

        System.out.print(sb);
    }
}
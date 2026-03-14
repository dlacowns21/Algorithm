package gold;

import java.io.*;
import java.util.*;

public class Boj_11729_하노이탑이동순서 {

    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        long moves = (1L << N) - 1;
        sb.append(moves).append("\n");

        hanoi(N, 1, 3, 2);

        System.out.print(sb);
    }

    static void hanoi(int n, int from, int to, int via) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }
        hanoi(n - 1, from, via, to);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(n - 1, via, to, from);
    }
}
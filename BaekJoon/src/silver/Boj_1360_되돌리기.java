package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_1360_되돌리기 {

    static class Node {
        char ch;
        Node prev;
        Node(char ch, Node prev) {
            this.ch = ch;
            this.prev = prev;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        long[] time = new long[N];
        Node[] state = new Node[N];

        Node cur = null;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("type")) {
                char c = st.nextToken().charAt(0);
                long t = Long.parseLong(st.nextToken());
                time[i] = t;

                cur = new Node(c, cur);
                state[i] = cur;

            } else {
                long undoSec = Long.parseLong(st.nextToken());
                long t = Long.parseLong(st.nextToken());
                time[i] = t;

                long targetTime = t - undoSec;
                int j = findLastIndexBefore(time, i, targetTime);

                cur = (j >= 0) ? state[j] : null;
                state[i] = cur;
            }
        }

        StringBuilder sb = new StringBuilder();
        Node p = cur;
        while (p != null) {
            sb.append(p.ch);
            p = p.prev;
        }
        sb.reverse();
        System.out.print(sb.toString());
    }

    private static int findLastIndexBefore(long[] time, int upto, long targetTime) {
        for (int i = upto - 1; i >= 0; i--) {
            if (time[i] < targetTime) return i;
        }
        return -1;
    }
}
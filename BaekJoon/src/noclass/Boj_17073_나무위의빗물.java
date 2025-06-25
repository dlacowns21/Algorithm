package noclass;

import java.io.*;
import java.util.*;

public class Boj_17073_나무위의빗물 {

    static int N;
    static double W;
    static List<Integer>[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Double.parseDouble(st.nextToken());

        tree = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree[u].add(v);
            tree[v].add(u);
        }

        int count = 0;

        for (int i = 2; i <= N; i++) {
            if (tree[i].size() == 1) {
                count++;
            }
        }

        System.out.println(W / count);
    }
}

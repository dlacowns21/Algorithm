package noclass;

import java.io.*;
import java.util.*;

public class Boj_14267_회사문화1 {

    static int n, m;
    static List<Integer>[] tree;
    static int[] praise;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        tree = new ArrayList[n + 1];
        praise = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int manager = Integer.parseInt(st.nextToken());
            if (manager != -1) {
                tree[manager].add(i);
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int employee = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            praise[employee] += value;
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(praise[i]).append(" ");
        }
        
        System.out.println(sb.toString().trim());
    }

    static void dfs(int cur) {
        for (int child : tree[cur]) {
            praise[child] += praise[cur];
            dfs(child);
        }
    }
}

package class4;

import java.io.*;
import java.util.*;

public class Boj_1865_웜홀 {

    static class Edge {
        int from, to, cost;

        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static int T, N, M, W;
    static List<Edge> edges;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            edges = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());

                edges.add(new Edge(s, e, time));
                edges.add(new Edge(e, s, time));
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());

                edges.add(new Edge(s, e, -time));
            }

            if (bf()) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.print(sb);
    }

    static boolean bf() {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, 0);

        for (int i = 1; i < N; i++) {
            for (Edge e : edges) {
                if (dist[e.to] > dist[e.from] + e.cost) {
                    dist[e.to] = dist[e.from] + e.cost;
                }
            }
        }

        for (Edge e : edges) {
            if (dist[e.to] > dist[e.from] + e.cost) {
                return true;
            }
        }

        return false;
    }
}
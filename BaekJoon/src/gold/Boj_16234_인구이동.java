package BaekJoon.src.gold;

import java.io.*;
import java.util.*;

public class Boj_16234_인구이동 {

    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;

    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    static class Pos {
        int r, c;
        Pos(int r, int c) { this.r = r; this.c = c; }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;

        while (true) {
            visited = new boolean[N][N];
            boolean moved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (bfsAndMove(i, j)) moved = true;
                    }
                }
            }

            if (!moved) break;
            days++;
        }

        System.out.println(days);
    }

    static boolean bfsAndMove(int sr, int sc) {
        Queue<Pos> q = new ArrayDeque<>();
        ArrayList<Pos> union = new ArrayList<>();

        visited[sr][sc] = true;
        q.add(new Pos(sr, sc));
        union.add(new Pos(sr, sc));

        int sum = map[sr][sc];

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (visited[nr][nc]) continue;

                int diff = Math.abs(map[cur.r][cur.c] - map[nr][nc]);
                if (diff < L || diff > R) continue;

                visited[nr][nc] = true;
                q.add(new Pos(nr, nc));
                union.add(new Pos(nr, nc));
                sum += map[nr][nc];
            }
        }

        if (union.size() <= 1) return false;

        int avg = sum / union.size();
        for (Pos p : union) {
            map[p.r][p.c] = avg;
        }
        return true;
    }
}
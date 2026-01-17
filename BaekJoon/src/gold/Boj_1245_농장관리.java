package BaekJoon.src.gold;

import java.io.*;
import java.util.*;

public class Boj_1245_농장관리 {

    static int N, M, ans;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];
        ans = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    if (bfs(i, j)) {
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);
    }

    public static boolean bfs(int sr, int sc) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> sameHeight = new ArrayList<>();

        queue.offer(new int[]{sr, sc});
        visited[sr][sc] = true;
        sameHeight.add(new int[]{sr, sc});

        int height = map[sr][sc];
        boolean isPeak = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for (int d = 0; d < 8; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (!check(nr, nc)) continue;

                if (map[nr][nc] > height) {
                    isPeak = false;
                }

                if (map[nr][nc] == height && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                    sameHeight.add(new int[]{nr, nc});
                }
            }
        }

        return isPeak;
    }

    public static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
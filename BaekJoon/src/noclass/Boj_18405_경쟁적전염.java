package noclass;

import java.io.*;
import java.util.*;

public class Boj_18405_경쟁적전염 {

    static int N, K, S, X, Y;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        List<int[]> viruses = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    viruses.add(new int[]{map[i][j], i, j, 0});
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        viruses.sort(Comparator.comparingInt(a -> a[0]));

        Queue<int[]> que = new LinkedList<>(viruses);

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int virus = cur[0];
            int r = cur[1];
            int c = cur[2];
            int time = cur[3];

            if (time == S) continue;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (check(nr, nc) && map[nr][nc] == 0) {
                    map[nr][nc] = virus;
                    que.offer(new int[]{virus, nr, nc, time + 1});
                }
            }
        }

        System.out.println(map[X - 1][Y - 1]);
    }

    public static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}

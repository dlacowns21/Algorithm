package silver;

import java.io.*;
import java.util.*;

public class Boj_14889_스타트와링크 {

    static int N;
    static int[][] map;
    static boolean[] selected;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        selected = new boolean[N];
        dfs(0, 0);
        System.out.println(ans);
    }

    static void dfs(int start, int cnt) {
        if (cnt == N / 2) {
            int startScore = 0, linkScore = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (selected[i] && selected[j]) startScore += map[i][j];
                    else if (!selected[i] && !selected[j]) linkScore += map[i][j];
                }
            }
            ans = Math.min(ans, Math.abs(startScore - linkScore));
            return;
        }

        for (int i = start; i < N; i++) {
            selected[i] = true;
            dfs(i + 1, cnt + 1);
            selected[i] = false;
        }
    }
}
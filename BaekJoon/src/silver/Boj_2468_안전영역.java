package silver;

import java.io.*;
import java.util.*;

public class Boj_2468_안전영역 {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        int maxHeight = 0;
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        int ans = 1;
        for(int water = 0; water < maxHeight; water++){
            visited = new boolean[N][N];
            int count = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!visited[i][j] && map[i][j] > water){
                        dfs(i, j, water);
                        count++;
                    }
                }
            }
            ans = Math.max(ans, count);
        }

        System.out.println(ans);
    }

    static void dfs(int r, int c, int water){
        visited[r][c] = true;
        for(int d = 0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            if(visited[nr][nc] || map[nr][nc] <= water) continue;
            dfs(nr, nc, water);
        }
    }
}
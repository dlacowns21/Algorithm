package silver;

import java.io.*;
import java.util.*;

public class Boj_5212_지구온난화 {

    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new boolean[R][C];
        map = new char[R][C];
        for(int i = 0; i < R; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(map[i][j] == 'X'){
                    int count = 0;
                    for(int d = 0; d < 4; d++){
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if(!check(nr, nc)) {
                            count++;
                            continue;
                        }
                        if(map[nr][nc] == '.') count++;
                    }
                    if(count >= 3) visited[i][j] = true;
                }
            }
        }

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(visited[i][j]) map[i][j] = '.';
            }
        }

        int rs = R, re = 0, cs = C, ce = 0;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(map[i][j] == 'X'){
                    if(i < rs) rs = i;
                    if(i > re) re = i;
                    if(j < cs) cs = j;
                    if(j > ce) ce = j;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = rs; i <= re; i++){
            for(int j = cs; j <= ce; j++){
                sb.append(map[i][j]);
                if(j == ce) sb.append('\n');
            }
        }

        System.out.println(sb);

    }

    public static boolean check(int r, int c){
        return r >= 0 && r < R && c >= 0 && c < C;
    }
}

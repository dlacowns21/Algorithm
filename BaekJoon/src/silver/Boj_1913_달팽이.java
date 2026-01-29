package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_1913_달팽이 {

    static int N, num;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = Integer.parseInt(br.readLine());

        map = new int[N][N];
        map[N / 2][N / 2] = 1;
        int r = N / 2;
        int c = N / 2;
        int val = 1;
        map[r][c] = val;
        int d = 0;
        int count = 1;
        while(val < N * N){
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < count; j++){
                    if (val == N * N) break;
                    r += dr[d];
                    c += dc[d];
                    map[r][c] = ++val;
                }
                if(d < 3) d++;
                else d = 0;
            }
            count++;
        }

        StringBuilder sb = new StringBuilder();
        int ar = 0;
        int ac = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sb.append(map[i][j]).append(" ");
                if(j == N - 1) sb.append("\n");
                if(map[i][j] == num){
                    ar = i + 1;
                    ac = j + 1;
                }
            }
        }

        sb.append(ar).append(" ").append(ac);

        System.out.println(sb.toString());
    }
}

package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_1018_체스판다시칠하기 {

    static int N, M;
    static char[][] map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }

        int minCount = Integer.MAX_VALUE;

        for(int i = 0; i <= N - 8; i++){
            for(int j = 0; j <= M - 8; j++){
                int count = minPaint(i, j);
                minCount = Math.min(minCount, count);
            }
        }

        System.out.println(minCount);
    }

    static int minPaint(int sr, int sc){
        int pattern1 = 0;
        int pattern2 = 0;

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                char current = map[sr + i][sc + j];

                if((i + j) % 2 == 0){
                    if(current != 'W') pattern1++;
                    if(current != 'B') pattern2++;
                } else {
                    if(current != 'B') pattern1++;
                    if(current != 'W') pattern2++;
                }
            }
        }

        return Math.min(pattern1, pattern2);
    }
}
package silver;

import java.io.*;
import java.util.*;

public class Boj_3085_사탕게임 {

    static int N, temp, ans;
    static char[][] map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                changec(i, j);
                temp = find();
                if (temp > ans) ans = temp;
                changec(i, j);
            }
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                changer(i, j);
                temp = find();
                if (temp > ans) ans = temp;
                changer(i, j);
            }
        }

        System.out.println(ans);
    }

    public static int find() {

        int max = 0;

        for(int i = 0; i < N; i++){
            int count = 1;
            for(int j = 0; j < N - 1; j++){
                if(map[i][j] == map[i][j + 1]) count++;
                else count = 1;
                if(max < count) max = count;
            }
        }

        for(int j = 0; j < N; j++){
            int count = 1;
            for(int i = 0; i < N - 1; i++){
                if(map[i][j] == map[i + 1][j]) count++;
                else count = 1;
                if(max < count) max = count;
            }
        }

        return max;
    }

    public static void changec(int r, int c){
        char temp = map[r][c];
        map[r][c] = map[r][c + 1];
        map[r][c + 1] = temp;
    }

    public static void changer(int r, int c){
        char temp = map[r][c];
        map[r][c] = map[r + 1][c];
        map[r + 1][c] = temp;
    }
}

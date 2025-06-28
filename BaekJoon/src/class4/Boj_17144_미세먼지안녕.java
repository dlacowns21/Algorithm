package class4;

import java.io.*;
import java.util.*;

public class Boj_17144_미세먼지안녕 {

    static int R, C, T;
    static int[][] map;
    static int[][] temp;
    static int top = -1, bottom = -1;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    if (top == -1) top = i;
                    else bottom = i;
                }
            }
        }

        while (T-- > 0) {
            spread();
            clean();
        }

        System.out.println(getTotal());
    }

    static void spread() {
        temp = new int[R][C];

        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                if (map[x][y] > 0) {
                    int amount = map[x][y] / 5;
                    int count = 0;

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];

                        if (nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == -1) continue;

                        temp[nx][ny] += amount;
                        count++;
                    }

                    temp[x][y] += map[x][y] - amount * count;
                } else if (map[x][y] == -1) {
                    temp[x][y] = -1;
                }
            }
        }

        map = temp;
    }

    static void clean() {
        for (int i = top - 1; i > 0; i--)
            map[i][0] = map[i - 1][0];
        for (int i = 0; i < C - 1; i++)
            map[0][i] = map[0][i + 1];
        for (int i = 0; i < top; i++)
            map[i][C - 1] = map[i + 1][C - 1];
        for (int i = C - 1; i > 1; i--)
            map[top][i] = map[top][i - 1];
        map[top][1] = 0;

        for (int i = bottom + 1; i < R - 1; i++)
            map[i][0] = map[i + 1][0];
        for (int i = 0; i < C - 1; i++)
            map[R - 1][i] = map[R - 1][i + 1];
        for (int i = R - 1; i > bottom; i--)
            map[i][C - 1] = map[i - 1][C - 1];
        for (int i = C - 1; i > 1; i--)
            map[bottom][i] = map[bottom][i - 1];
        map[bottom][1] = 0;
    }

    static int getTotal() {
        int total = 0;
        for (int[] row : map) {
            for (int val : row) {
                if (val > 0) total += val;
            }
        }
        return total;
    }
}

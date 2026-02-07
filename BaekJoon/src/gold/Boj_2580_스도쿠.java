package BaekJoon.src.gold;

import java.io.*;
import java.util.*;

public class Boj_2580_스도쿠 {

    static int[][] map = new int[9][9];
    static List<int[]> emptyCells = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    emptyCells.add(new int[]{i, j});
                }
            }
        }

        solve(0);
    }

    static void solve(int count) {
        if (count == emptyCells.size()) {
            printMap();
            System.exit(0);
        }

        int[] cell = emptyCells.get(count);
        int row = cell[0];
        int col = cell[1];

        for (int i = 1; i <= 9; i++) {
            if (isValid(row, col, i)) {
                map[row][col] = i;
                solve(count + 1);
                map[row][col] = 0;
            }
        }
    }

    static boolean isValid(int row, int col, int val) {
        for (int i = 0; i < 9; i++) {
            if (map[row][i] == val || map[i][col] == val) {
                return false;
            }
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (map[i][j] == val) {
                    return false;
                }
            }
        }

        return true;
    }

    static void printMap() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
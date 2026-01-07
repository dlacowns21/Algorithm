package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_1063_킹 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] line = st.nextToken().toCharArray();
        int[] king = new int[2];
        king[0] = line[0] - 'A';
        king[1] = line[1] - '1';

        line = st.nextToken().toCharArray();
        int[] stone = new int[2];
        stone[0] = line[0] - 'A';
        stone[1] = line[1] - '1';

        int N = Integer.parseInt(st.nextToken());

        Map<String, int[]> directions = new HashMap<>();
        directions.put("R", new int[]{1, 0});
        directions.put("L", new int[]{-1, 0});
        directions.put("B", new int[]{0, -1});
        directions.put("T", new int[]{0, 1});
        directions.put("RT", new int[]{1, 1});
        directions.put("LT", new int[]{-1, 1});
        directions.put("RB", new int[]{1, -1});
        directions.put("LB", new int[]{-1, -1});

        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            int[] dir = directions.get(command);

            int newKingCol = king[0] + dir[0];
            int newKingRow = king[1] + dir[1];

            if (!isValid(newKingCol, newKingRow)) {
                continue;
            }

            if (newKingCol == stone[0] && newKingRow == stone[1]) {
                int newStoneCol = stone[0] + dir[0];
                int newStoneRow = stone[1] + dir[1];

                if (!isValid(newStoneCol, newStoneRow)) {
                    continue;
                }

                stone[0] = newStoneCol;
                stone[1] = newStoneRow;
            }

            king[0] = newKingCol;
            king[1] = newKingRow;
        }

        System.out.println(positionToString(king));
        System.out.println(positionToString(stone));
    }

    private static boolean isValid(int col, int row) {
        return col >= 0 && col < 8 && row >= 0 && row < 8;
    }

    private static String positionToString(int[] pos) {
        char col = (char)('A' + pos[0]);
        char row = (char)('1' + pos[1]);
        return "" + col + row;
    }
}
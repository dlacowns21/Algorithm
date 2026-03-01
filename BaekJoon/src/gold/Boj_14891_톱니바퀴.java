package gold;

import java.io.*;
import java.util.*;

public class Boj_14891_톱니바퀴 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] gear = new int[4][8];

        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                gear[i][j] = line.charAt(j) - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            int[] dirs = new int[4];
            dirs[num] = dir;

            for (int i = num; i < 3; i++) {
                if (gear[i][2] != gear[i+1][6]) {
                    dirs[i+1] = -dirs[i];
                } else break;
            }

            for (int i = num; i > 0; i--) {
                if (gear[i][6] != gear[i-1][2]) {
                    dirs[i-1] = -dirs[i];
                } else break;
            }

            for (int i = 0; i < 4; i++) {
                if (dirs[i] == 1) {
                    int tmp = gear[i][7];
                    for (int j = 7; j > 0; j--) gear[i][j] = gear[i][j-1];
                    gear[i][0] = tmp;
                } else if (dirs[i] == -1) {
                    int tmp = gear[i][0];
                    for (int j = 0; j < 7; j++) gear[i][j] = gear[i][j+1];
                    gear[i][7] = tmp;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < 4; i++) {
            if (gear[i][0] == 1) ans += (1 << i);
        }
        System.out.println(ans);
    }
}
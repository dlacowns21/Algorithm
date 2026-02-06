package BaekJoon.src.silver;

import java.io.*;

public class Boj_8911_거북이 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String cmd = br.readLine().trim();

            int x = 0, y = 0;
            int d = 0;

            int minX = 0, maxX = 0, minY = 0, maxY = 0;

            for (int i = 0; i < cmd.length(); i++) {
                char c = cmd.charAt(i);

                if (c == 'L') {
                    d = (d + 3) % 4;
                } else if (c == 'R') {
                    d = (d + 1) % 4;
                } else if (c == 'F') {
                    x += dx[d];
                    y += dy[d];
                } else if (c == 'B') {
                    x -= dx[d];
                    y -= dy[d];
                }

                if (x < minX) minX = x;
                if (x > maxX) maxX = x;
                if (y < minY) minY = y;
                if (y > maxY) maxY = y;
            }

            int area = (maxX - minX) * (maxY - minY);
            sb.append(area).append('\n');
        }

        System.out.print(sb.toString());
    }
}
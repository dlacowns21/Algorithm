package class4;

import java.io.*;
import java.util.*;

public class Boj_9205_맥주마시면서걸어가기 {

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int distance(Point p) {
            return Math.abs(this.x - p.x) + Math.abs(this.y - p.y);
        }
    }

    static Point[] points;
    static boolean[] visited;
    static int t, n;

    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            points = new Point[n + 2];
            visited = new boolean[n + 2];

            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points[i] = new Point(x, y);
            }

            if (bfs()) {
                sb.append("happy\n");
            } else {
                sb.append("sad\n");
            }
        }

        System.out.print(sb);
    }

    static boolean bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < n + 2; i++) {
                if (!visited[i] && points[cur].distance(points[i]) <= 1000) {
                    visited[i] = true;
                    queue.add(i);

                    if (i == n + 1) return true;
                }
            }
        }

        return false;
    }
}

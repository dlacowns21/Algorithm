package noclass;

import java.io.*;
import java.util.*;

public class Boj_11000_강의실배정 {
	
	static int n;
	static int[][] map;

    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(map, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(map[0][1]);

        for (int i = 1; i < n; i++) {
            if (map[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.offer(map[i][1]);
        }

        System.out.println(pq.size());
    }
}


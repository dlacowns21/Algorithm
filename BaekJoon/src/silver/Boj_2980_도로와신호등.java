package silver;

import java.io.*;
import java.util.*;

public class Boj_2980_도로와신호등 {

    static int N, L;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        int totalTime = 0;
        int currentPos = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());

            totalTime += (D - currentPos);
            currentPos = D;

            int cycle = R + G;
            int status = totalTime % cycle;

            if (status < R) {
                totalTime += (R - status);
            }
        }

        totalTime += (L - currentPos);

        System.out.println(totalTime);
    }
}

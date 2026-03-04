package silver;

import java.io.*;
import java.util.*;

public class Boj_2491_수열 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(1);
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxLen = 1;
        int upLen = 1;
        int downLen = 1;

        for (int i = 0; i < N - 1; i++) {

            if (arr[i] <= arr[i + 1]) {
                upLen++;
            } else {
                upLen = 1;
            }

            if (arr[i] >= arr[i + 1]) {
                downLen++;
            } else {
                downLen = 1;
            }

            maxLen = Math.max(maxLen, Math.max(upLen, downLen));
        }

        System.out.println(maxLen);
    }
}
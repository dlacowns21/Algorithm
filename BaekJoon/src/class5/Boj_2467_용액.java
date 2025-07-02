package class5;

import java.io.*;
import java.util.*;

public class Boj_2467_용액 {
	
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N - 1;

        int min = Integer.MAX_VALUE;
        int al = arr[left];
        int ar = arr[right];

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                al = arr[left];
                ar = arr[right];
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(al + " " + ar);
    }
}

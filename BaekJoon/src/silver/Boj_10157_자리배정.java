package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_10157_자리배정 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        int total = C * R;
        if (K > total) {
            System.out.println(0);
            return;
        }

        int left = 1, right = C, bottom = 1, top = R;
        int x = 1, y = 1;
        int num = 1;

        while (true) {
            if (num == K) {
                System.out.println(x + " " + y);
                return;
            }

            while (y < top) {
                y++;
                num++;
                if (num == K) { System.out.println(x + " " + y); return; }
            }
            left++;

            while (x < right) {
                x++;
                num++;
                if (num == K) { System.out.println(x + " " + y); return; }
            }
            top--;

            while (y > bottom) {
                y--;
                num++;
                if (num == K) { System.out.println(x + " " + y); return; }
            }
            right--;

            while (x > left) {
                x--;
                num++;
                if (num == K) { System.out.println(x + " " + y); return; }
            }
            bottom++;
        }
    }
}
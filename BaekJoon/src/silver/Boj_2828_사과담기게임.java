package silver;

import java.io.*;
import java.util.*;

public class Boj_2828_사과담기게임 {

    static int N, M;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int J = Integer.parseInt(br.readLine());

        int left = 1;
        int right = M;
        int totalMove = 0;

        for (int i = 0; i < J; i++) {
            int pos = Integer.parseInt(br.readLine());

            if (pos < left) {
                totalMove += left - pos;
                left = pos;
                right = left + M - 1;
            } else if (pos > right) {
                totalMove += pos - right;
                right = pos;
                left = right - M + 1;
            }
        }

        System.out.println(totalMove);
    }
}
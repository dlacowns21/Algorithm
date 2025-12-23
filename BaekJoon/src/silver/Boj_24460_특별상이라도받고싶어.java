package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_24460_특별상이라도받고싶어 {

    static int N, ans;
    static int[][] num;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        num = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = divide(0, 0, N);
        System.out.println(ans);
    }

    static int divide(int x, int y, int size) {

        if(size == 1) {
            return num[x][y];
        }

        int half = size / 2;

        int leftTop = divide(x, y, half);
        int rightTop = divide(x, y + half, half);
        int leftBottom = divide(x + half, y, half);
        int rightBottom = divide(x + half, y + half, half);

        int[] nums = {leftTop, rightTop, leftBottom, rightBottom};
        Arrays.sort(nums);

        return nums[1];
    }
}
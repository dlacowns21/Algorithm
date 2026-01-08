package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_1138_한줄로서기 {

    static int N;
    static int[] nums;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[N];

        for(int height = 1; height <= N; height++){
            int count = nums[height - 1];
            int emptyCount = 0;

            for(int i = 0; i < N; i++){
                if(result[i] == 0){
                    if(emptyCount == count){
                        result[i] = height;
                        break;
                    }
                    emptyCount++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(result[i]);
            if(i < N - 1) sb.append(" ");
        }
        System.out.println(sb);
    }
}
package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_1158_요세푸스문제 {

    static int N, K;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        Queue<Integer> que = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            que.offer(i);
        }

        while(!que.isEmpty()){
            for(int i = 0; i < K - 1; i++){
                int temp = que.poll();
                que.offer(temp);
            }
            int num = que.poll();
            sb.append(num);
            if(!que.isEmpty()) sb.append(",").append(" ");
        }

        sb.append(">");

        System.out.println(sb);
    }
}

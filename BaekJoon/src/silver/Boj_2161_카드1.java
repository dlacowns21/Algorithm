package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_2161_카드1 {

    static int N;
    static Queue<Integer> que = new LinkedList<Integer>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){
            que.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        while(!que.isEmpty()){
            sb.append(que.poll()).append(" ");
            if(que.isEmpty()) break;
            else {
                que.offer(que.poll());
            }
        }

        System.out.println(sb);

    }
}

package class3;

import java.io.*;
import java.util.*;

public class Boj_11286_절대값힙 {

    public static void main(String[] args) throws Exception {

        PriorityQueue<Integer> ppq = new PriorityQueue<>();
        PriorityQueue<Integer> mpq = new PriorityQueue<>(Collections.reverseOrder());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num != 0){
                if(num > 0){
                    ppq.offer(num);
                } else {
                    mpq.offer(num);
                }
            } else {
                int temp = 0;
                if(!ppq.isEmpty() && !mpq.isEmpty()){
                    int ppqnum = ppq.peek();
                    int mpqnum = mpq.peek();
                    if(Math.abs(ppqnum) < Math.abs(mpqnum)){
                        temp = ppq.poll();
                        sb.append(temp).append("\n");
                    } else {
                        temp = mpq.poll();
                        sb.append(temp).append("\n");
                    }
                } else if (!ppq.isEmpty() && mpq.isEmpty()){
                    temp = ppq.poll();
                    sb.append(temp).append("\n");
                } else if(ppq.isEmpty() && !mpq.isEmpty()){
                    temp = mpq.poll();
                    sb.append(temp).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
        }
        System.out.println(sb);


    }
}

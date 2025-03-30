package noclass;

import java.io.*;
import java.util.*;

public class Boj_14698_전생했더니슬라임연구자였던건에대하여Hard {

    static final int MOD = 1000000007;
    static int T, N;
    
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        T = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();           
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }            
            long answer = 1;
            while(pq.size() > 1) {
                long a = pq.poll();
                long b = pq.poll();                
                long combined = a * b;
                answer = (answer * (combined % MOD)) % MOD;                
                pq.offer(combined);
            }
            sb.append(answer).append("\n");
        }      
        System.out.print(sb);
    }
}
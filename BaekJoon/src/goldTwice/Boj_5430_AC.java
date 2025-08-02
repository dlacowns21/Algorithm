package goldTwice;

import java.io.*;
import java.util.*;

public class Boj_5430_AC {
    
    static int T, n;
    static char[] p;
    static Deque<Integer> dq;
    static boolean front;
    static StringBuilder sb;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < T; t++) {
            
            String answer = "";
            front = true;
            
            p = br.readLine().toCharArray();
            int len = p.length;
            
            n = Integer.parseInt(br.readLine());
            
            dq = new LinkedList<Integer>();
            String line = br.readLine();
            
            if(n > 0) {
                String[] numbers = line.substring(1, line.length()-1).split(",");
                for(String num : numbers) {
                    dq.add(Integer.parseInt(num.trim()));
                }
            }
            
            for(int i = 0; i < len; i++) {
                if(p[i] == 'R') {
                    front = !front;
                } else {
                    if(dq.isEmpty()) {
                        answer = "error";
                        break;
                    } else {
                        if(front) dq.pollFirst();
                        else dq.pollLast();
                    }
                }
            }
            
            if(answer.equals("error")) {
                System.out.println("error");
            } else {
                sb = new StringBuilder();
                sb.append("[");
                
                boolean first = true;
                if(front) {
                    while(!dq.isEmpty()) {
                        if(!first) sb.append(",");
                        sb.append(dq.pollFirst());
                        first = false;
                    }
                } else {
                    while(!dq.isEmpty()) {
                        if(!first) sb.append(",");
                        sb.append(dq.pollLast());
                        first = false;
                    }
                }
                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}
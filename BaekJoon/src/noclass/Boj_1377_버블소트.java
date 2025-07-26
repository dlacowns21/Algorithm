package noclass;

import java.io.*;
import java.util.*;

public class Boj_1377_버블소트 {
    
    static int N, max;
    static int[] map;
    static int[][] imap;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        map = new int[N];
        for(int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }
        
        imap = new int[N][2];
        for(int i = 0; i < N; i++) {
            imap[i][0] = map[i];
            imap[i][1] = i;
        }
        
        Arrays.sort(imap, (a, b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        for(int i = 0; i < N; i++) {
            int origin = imap[i][1];
            int sorted = i;

            int move = origin - sorted;
            if(move > 0) {
                max = Math.max(max, move);
            }
        }

        System.out.println(max + 1);
    }
}
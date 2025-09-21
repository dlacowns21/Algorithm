package noclass;

import java.io.*;
import java.util.*;

public class Boj_14248_점프점프 {
    
    static int N, S, answer;
    static int[] map;
    static boolean[] visited;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N];
        visited = new boolean[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        
        S = Integer.parseInt(br.readLine());
        
        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(S - 1);
        visited[S - 1] = true;
        
        while(!que.isEmpty()) {
            int cur = que.poll();
            int dist = map[cur];
            int left = cur - dist;
            int right = cur + dist;

            if(left >= 0 && !visited[left]) {
                visited[left] = true;
                que.offer(left);
            }

            if(right < N && !visited[right]) {
                visited[right] = true;
                que.offer(right);
            }
        }

        for(int i = 0; i < N; i++) {
            if(visited[i]) answer++;
        }
        
        System.out.println(answer);
    }
}
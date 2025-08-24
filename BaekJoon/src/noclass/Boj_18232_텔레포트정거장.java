package noclass;

import java.io.*;
import java.util.*;

public class Boj_18232_텔레포트정거장 {
    
    static int N, M, S, E;
    static List<Integer>[] map;
    static int[] dist;
    
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        map = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x].add(y);
            map[y].add(x);
        }
        
        System.out.println(bfs());
    }
    
    static int bfs() {
        Queue<Integer> que = new LinkedList<>();
        dist = new int[N + 1];
        Arrays.fill(dist, -1);
        
        que.offer(S);
        dist[S] = 0;
        
        while (!que.isEmpty()) {
            int cur = que.poll();
            
            if (cur == E) {
                return dist[E];
            }

            if (cur - 1 >= 1 && dist[cur - 1] == -1) {
                dist[cur - 1] = dist[cur] + 1;
                que.offer(cur - 1);
            }
            
            if (cur + 1 <= N && dist[cur + 1] == -1) {
                dist[cur + 1] = dist[cur] + 1;
                que.offer(cur + 1);
            }

            for (int next : map[cur]) {
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    que.offer(next);
                }
            }
        }
        
        return dist[E];
    }
}
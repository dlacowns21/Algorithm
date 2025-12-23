package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_6118_숨바꼭질 {

    static int N, M;
    static ArrayList<Integer>[] graph;
    static int[] dist;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N  + 1];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        dist = new int[N  + 1];
        Arrays.fill(dist, -1);
        bfs(1);

        int max = 0;
        for(int i = 0; i <= N; i++){
            max = Math.max(max, dist[i]);
        }

        int minnode = Integer.MAX_VALUE;
        int count = 0;

        for(int i = 1; i <= N; i++){
            if(dist[i] == max){
                count++;
                minnode = Math.min(minnode, i);
            }
        }

        System.out.println(minnode + " " + max + " " + count);

    }

    static void bfs(int start){
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        dist[start] = 0;

        while(!que.isEmpty()){
            int cur = que.poll();
            for(int next : graph[cur]){
                if(dist[next] == -1){
                    dist[next] = dist[cur] + 1;
                    que.offer(next);
                }
            }
        }
    }
}
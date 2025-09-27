package class4.silver_twice;

import java.io.*;
import java.util.*;

public class Boj_11725_트리의부모찾기 {
	
	static int N;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] parent;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		parent = new int[N + 1];
		visited = new boolean[N + 1];
		
		for(int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		bfs(1);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 2; i <= N; i++) {
			sb.append(parent[i]).append("\n");
		}
		
		System.out.println(sb);

	}
	
	public static void bfs(int root) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(root);
		visited[root] = true;
		
		while(!que.isEmpty()) {
			int cur = que.poll();
			
			for(int next : graph.get(cur)) {
				if(!visited[next]) {
					visited[next] = true;
					parent[next] = cur;
					que.offer(next);
				}
			}
		}
	}

}

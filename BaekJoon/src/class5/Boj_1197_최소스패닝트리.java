package class5;

import java.io.*;
import java.util.*;

public class Boj_1197_최소스패닝트리 {
	
	static int V, E;
	static int[] parent;
	static Edge[] edges;
	
	static class Edge implements Comparable<Edge> {
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		edges = new Edge[E];
		parent = new int[V + 1];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(a, b, c);
		}
		
		Arrays.sort(edges);
		
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}

		long answer = 0;
		int count = 0;
		
		for (int i = 0; i < E; i++) {
			Edge edge = edges[i];

			if (union(edge.from, edge.to)) {
				answer += edge.weight;
				count++;
				
				if (count == V - 1) {
					break;
				}
			}
		}
		
		System.out.println(answer);
	}
	
	static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x == y) {
			return false;
		}
		
		parent[y] = x;
		return true;
	}
}
package BaekJoon.src.gold;

import java.io.*;
import java.util.*;

public class Boj_1068_트리 {

    static int N, root;
    static int[] parent;
    static List<Integer>[] children;
    static boolean[] deleted;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        parent = new int[N];
        children = new ArrayList[N];
        deleted = new boolean[N];

        for(int i = 0; i < N; i++) {
            children[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
            if(parent[i] == -1) {
                root = i;
            } else {
                children[parent[i]].add(i);
            }
        }

        int deleteNode = Integer.parseInt(br.readLine());

        if(deleteNode == root) {
            System.out.println(0);
            return;
        }

        markDeleted(deleteNode);

        int leafCount = count(root);
        System.out.println(leafCount);
    }

    static void markDeleted(int node) {
        deleted[node] = true;
        for(int child : children[node]) {
            markDeleted(child);
        }
    }

    static int count(int node) {
        if(deleted[node]) {
            return 0;
        }

        int childCount = 0;
        int leafCount = 0;

        for(int child : children[node]) {
            if(!deleted[child]) {
                childCount++;
                leafCount += count(child);
            }
        }

        if(childCount == 0) {
            return 1;
        }

        return leafCount;
    }
}
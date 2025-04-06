package noclass;

import java.io.*;
import java.util.*;

public class Boj_14426_접두사찾기 {

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord;
    }
    
    static void insert(TrieNode root, String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isEndOfWord = true;
    }

    static boolean hasPrefix(TrieNode root, String word) {
        TrieNode node = root;
        StringBuilder prefix = new StringBuilder();	
        
        for (char c : word.toCharArray()) {
            prefix.append(c);
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
            if (node.isEndOfWord) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        TrieNode root = new TrieNode();

        for (int i = 0; i < N; i++) {
            insert(root, br.readLine());
        }
        
        int count = 0;

        for (int i = 0; i < M; i++) {
            String testStr = br.readLine();
            if (hasPrefix(root, testStr)) {
                count++;
            }
        }
        
        System.out.println(count);
    }
}
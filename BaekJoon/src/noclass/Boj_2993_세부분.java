package noclass;

import java.io.*;
import java.util.*;

public class Boj_2993_세부분 {

    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String word = br.readLine();
        int len = word.length();
        
        String result = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        
        for (int i = 1; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                String part1 = word.substring(0, i);
                String part2 = word.substring(i, j);
                String part3 = word.substring(j);
                
                part1 = reverse(part1);
                part2 = reverse(part2);
                part3 = reverse(part3);
                
                String newWord = part1 + part2 + part3;

                if (newWord.compareTo(result) < 0) {
                    result = newWord;
                }
            }
        }
        
        System.out.println(result);
    }
    
    public static String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
}
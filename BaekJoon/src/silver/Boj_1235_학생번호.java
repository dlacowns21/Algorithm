package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_1235_학생번호 {

    static int N, ans, length;
    static String[] nums;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        nums = new String[N];
        for(int i = 0; i < N; i++){
            nums[i] = br.readLine();
        }

        int length = nums[0].length();

        ans = 1;
        while(true){
            HashSet<String> set = new HashSet<>();
            for(int i = 0; i < N; i++){
                String temp = nums[i].substring(length - ans);
                set.add(temp);
            }
            if(set.size() == N) break;
            ans++;
        }

        System.out.println(ans);
    }
}

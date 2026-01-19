package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_1316_그룹단어체커 {

    static int N, ans;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            if(line.length() == 1){
                ans++;
                continue;
            }
            HashSet<Character> set = new HashSet<Character>();
            set.add(line.charAt(0));
            int count = 0;
            for(int j = 1; j < line.length(); j++){
                if(line.charAt(j) == line.charAt(j - 1)) {
                    count++;
                    continue;
                } else{
                    if(set.contains(line.charAt(j))) break;
                    else{
                        count++;
                        set.add(line.charAt(j));
                    }
                }
            }
            if(count == line.length() - 1) ans++;
        }

        System.out.println(ans);

    }
}

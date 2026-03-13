package silver;

import java.io.*;
import java.util.*;

public class Boj_10815_숫자카드 {

    static int N, M;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            set.add(num);
        }

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            int num = Integer.parseInt(st.nextToken());
            if(set.contains(num)) sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }

        System.out.println(sb);
    }
}

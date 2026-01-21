package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_1270_전쟁땅따먹기 {

    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int t = 0; t < N; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int length = Integer.parseInt(st.nextToken());

            long[] map = new long[length];
            for(int i = 0; i < length; i++){
                map[i] = Long.parseLong(st.nextToken());
            }

            Arrays.sort(map);

            int count = 1;
            double half = (double) length / 2;
            for(int i = 0; i < length - 1; i++){
                if(map[i] == map[i + 1]) {
                    count++;
                    if(count > half){
                        sb.append(map[i]).append("\n");
                        break;
                    }
                } else {
                    count = 1;
                }
            }

            if(count <= half){
                sb.append("SYJKGW").append("\n");
            }

        }

        System.out.println(sb);

    }
}

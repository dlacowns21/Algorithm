package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_1380_귀걸이 {

    static int N, T;
    static String[] name;
    static HashSet<Integer> seq;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        T = 1;

        while(T != 0){

            N = Integer.parseInt(br.readLine());

            seq = new HashSet<Integer>();

            if(N == 0) break;

            name = new String[N];
            for(int i = 0; i < N; i++){
                name[i] = br.readLine();
            }

            for(int i = 0; i < 2 * N - 1; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                String ab = st.nextToken();
                if(seq.contains(num)){
                    seq.remove(num);
                } else {
                    seq.add(num);
                }
            }

            int stud = seq.iterator().next() - 1;
            String studName = name[stud];
            sb.append(T + " " + studName + "\n");

            T++;
        }

        System.out.println(sb);
    }
}

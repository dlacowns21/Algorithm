package silver;

import java.io.*;
import java.util.*;

public class Boj_8979_올림픽 {

    static int N, K;
    static int[][] medal;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        medal = new int[N][4];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++){
                medal[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] kMedal = null;
        for(int i = 0; i < N; i++){
            if(medal[i][0] == K){
                kMedal = medal[i];
                break;
            }
        }

        int rank = 1;
        for(int i = 0; i < N; i++){
            if(medal[i][0] == K) continue;
            if(medal[i][1] > kMedal[1] ||
                    (medal[i][1] == kMedal[1] && medal[i][2] > kMedal[2]) ||
                    (medal[i][1] == kMedal[1] && medal[i][2] == kMedal[2] && medal[i][3] > kMedal[3])){
                rank++;
            }
        }

        System.out.println(rank);
    }
}
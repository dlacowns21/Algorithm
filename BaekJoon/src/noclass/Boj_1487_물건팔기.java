package noclass;

import java.io.*;
import java.util.*;

public class Boj_1487_물건팔기 {

    static int N;
    static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        map = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(map[i][0]);
        }
        List<Integer> prices = new ArrayList<>(set);
        Collections.sort(prices);
        
        int max = 0;
        int ans = 0;

        for (int price : prices) {
            int profit = 0;
            for (int i = 0; i < N; i++) {
                int cost = map[i][0];
                int deliver = map[i][1];

                if (price <= cost) {
                    if (price > deliver) {
                        profit += (price - deliver);
                    }
                }
            }

            if (profit > max) {
                max = profit;
                ans = price;
            }
        }
        
        System.out.println(ans);
    }
}
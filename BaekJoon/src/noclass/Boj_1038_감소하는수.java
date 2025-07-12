package noclass;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1038_감소하는수 {

    static ArrayList<Long> list = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list.add(0L);

        for (int i = 1; i <= 9; i++) {
            dfs(i, i);
        }

        Collections.sort(list);

        if (N >= list.size()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(N));
        }
    }

    static void dfs(long num, int last) {
        list.add(num);
        for (int i = 0; i < last; i++) {
            dfs(num * 10 + i, i);
        }
    }
}

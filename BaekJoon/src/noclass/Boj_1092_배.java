package noclass;

import java.io.*;
import java.util.*;

public class Boj_1092_배 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] cranes = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	cranes[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        List<Integer> boxes = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
        	boxes.add(Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(cranes, Collections.reverseOrder());
        boxes.sort(Collections.reverseOrder());

        if (cranes[0] < boxes.get(0)) {
            System.out.println(-1);
            return;
        }

        int time = 0;
        while (!boxes.isEmpty()) {
            int idx = 0;
            for (int i = 0; i < N;) {
                if (idx == boxes.size()) break;
                if (cranes[i] >= boxes.get(idx)) {
                    boxes.remove(idx);
                    i++;
                } else {
                    idx++;
                }
            }
            time++;
        }

        System.out.println(time);
    }
}

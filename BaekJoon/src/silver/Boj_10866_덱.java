package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_10866_덱 {

    static int N;
    static Deque<Integer> deque = new LinkedList<Integer>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push_front")){
                deque.addFirst(Integer.parseInt(st.nextToken()));
            } else if(command.equals("push_back")){
                deque.addLast(Integer.parseInt(st.nextToken()));
            } else if(command.equals("pop_front")){
                if(deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.pollFirst());
            } else if(command.equals("pop_back")){
                if(deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.pollLast());
            } else if(command.equals("size")){
                System.out.println(deque.size());
            } else if(command.equals("empty")){
                if(deque.isEmpty()) System.out.println(1);
                else System.out.println(0);
            } else if(command.equals("front")){
                if(!deque.isEmpty()) System.out.println(deque.getFirst());
                else System.out.println(-1);
            } else {
                if(!deque.isEmpty()) System.out.println(deque.getLast());
                else System.out.println(-1);
            }
        }
    }
}

package silver;

import java.io.*;
import java.util.*;

public class Boj_10773_제로 {

    static int K, ans;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        for(int i = 0; i < K; i++){
            int num = Integer.parseInt(br.readLine());
            if(num != 0){
                stack.push(num);
            } else {
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
        }

        while(!stack.isEmpty()){
            ans += stack.pop();
        }

        System.out.println(ans);
    }
}

package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_1058_친구 {

    static int N;
    static char[][] map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        for(int i = 0; i < N; i++){
            char[] line = br.readLine().toCharArray();
            for(int j = 0; j < N; j++){
                map[i][j] = line[j];
            }
        }

        int max = 0;

        for(int i = 0; i < N; i++){
            int two = countTwo(i);
            max = Math.max(max, two);
        }

        System.out.println(max);
    }

    static int countTwo(int person){
        boolean[] isTwo = new boolean[N];

        for(int j = 0; j < N; j++){
            if(person == j) continue;

            if(map[person][j] == 'Y'){
                isTwo[j] = true;
            }
            else {
                for(int k = 0; k < N; k++){
                    if(map[person][k] == 'Y' && map[k][j] == 'Y'){
                        isTwo[j] = true;
                        break;
                    }
                }
            }
        }

        int count = 0;
        for(int i = 0; i < N; i++){
            if(isTwo[i]) count++;
        }

        return count;
    }
}

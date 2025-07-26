package noclass;

import java.io.*;

public class Boj_3085_사탕게임 {

    static int N, max;
    static char[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        for(int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < N; j++) {
                map[i][j] = input[j];
            }
        }

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                for(int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(check(nr, nc)) {
                        if(map[r][c] != map[nr][nc]) {
                            swap(r, c, nr, nc);

                            int curmax = maxCon();
                            max = Math.max(max, curmax);
                            
                            swap(r, c, nr, nc);
                        }
                    }
                }
            }
        }

        System.out.println(max);
    }
    
    static boolean check(int r, int c) {
    	return r >= 0 && r < N && c >= 0 && c < N;
    }

    static void swap(int r1, int c1, int r2, int c2) {
        char temp = map[r1][c1];
        map[r1][c1] = map[r2][c2];
        map[r2][c2] = temp;
    }

    static int maxCon() {
    	
        int maxLen = 1;

        for(int i = 0; i < N; i++) {
            int count = 1;
            for(int j = 1; j < N; j++) {
                if(map[i][j] == map[i][j-1]) {
                    count++;
                } else {
                    maxLen = Math.max(maxLen, count);
                    count = 1;
                }
            }
            maxLen = Math.max(maxLen, count);
        }

        for(int j = 0; j < N; j++) {
            int count = 1;
            for(int i = 1; i < N; i++) {
                if(map[i][j] == map[i-1][j]) {
                    count++;
                } else {
                    maxLen = Math.max(maxLen, count);
                    count = 1;
                }
            }
            maxLen = Math.max(maxLen, count);
        }

        return maxLen;
    }
}
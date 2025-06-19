package noclass;

import java.io.*;
import java.util.*;

public class Boj_16197_두동전 {
	
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int N, M;
    static char[][] map;
    static boolean[][][][] visited;
    
    public static void main(String[] args)throws Exception{
    	
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M][N][M];
        
        
        List<int[]> coins = new ArrayList<>();
        
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j]=s.charAt(j);
                if(map[i][j]=='o'){
                    coins.add(new int[]{i, j, 0});
                }
            }
        }

        Queue<int[]> que = new LinkedList<>();
        int[] c1 = coins.get(0);
        int[] c2 = coins.get(1);
        que.add(new int[]{c1[0],c1[1],c2[0],c2[1],0});
        visited[c1[0]][c1[1]][c2[0]][c2[1]] = true;
        
        while(!que.isEmpty()){
            int[] coin = que.poll();
            int y1 = coin[0];
            int x1 = coin[1];
            int y2 = coin[2];
            int x2 = coin[3];
            int cnt = coin[4];
            
            if(cnt >= 10) break;
            
            for(int i = 0; i < 4; i++){
                int ny1 = y1 + dy[i];
                int nx1 = x1 + dx[i];
                int ny2 = y2 + dy[i];
                int nx2 = x2 + dx[i];
                
                boolean out1 = isOut(ny1, nx1);
                boolean out2 = isOut(ny2, nx2);
                
                if(out1 && out2) continue;
                if(out1 || out2){
                    System.out.println(cnt + 1);
                    return;
                }
                if(map[ny1][nx1] == '#'){
                    ny1 = y1;
                    nx1 = x1;
                }
                if(map[ny2][nx2] == '#'){
                    ny2 = y2;
                    nx2 = x2;
                }
                if(visited[ny1][nx1][ny2][nx2])continue;
                
                que.add(new int[]{ny1, nx1, ny2, nx2, cnt + 1});
                visited[ny1][nx1][ny2][nx2] = true;
            }
        }
        
        System.out.println(-1);
    }
    
    public static boolean isOut(int y,int x){
        return y < 0 || x < 0 || y >= N || x >= M;
    }
    
}

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m, result;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < m ; j++) {
                visited[i][j] = true;
                dfs(1, map[i][j], i, j);
                visited[i][j] = false;
            }
        }

        System.out.println(result);
    }

    static void dfs(int cur, int sum, int cx , int cy) {
        if( cur == 3 ) {
            if(sum > result) {
                result = sum;
            }
            return;
        }
        
        for (int i = 0 ; i < 4 ; i ++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) continue;

            
            visited[nx][ny] = true;
            dfs(cur+1, sum + map[nx][ny], nx, ny);
            visited[nx][ny] = false;
            
        }
    }
}
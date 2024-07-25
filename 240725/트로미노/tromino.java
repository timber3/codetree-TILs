import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m, result;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,1,0};
    static int[] dy = {1,0,-1};

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
                dfs(0, map[i][j], i, j);
            }
        }

        System.out.println(result);
    }

    static void dfs(int cur, int sum, int i , int j) {
        if( cur == 2 ) {
            if(sum > result) {
                result = sum;
            }
            return;
        }
        if ( i+1 < n && !visited[i+1][j]) {
            visited[i+1][j] = true;
            dfs(cur + 1, sum + map[i+1][j] , i+1, j);
            visited[i+1][j] = false;
        }
        if ( j+1 < m && !visited[i][j+1]) {
            visited[i][j+1] = true;
            dfs(cur + 1, sum + map[i][j+1] , i, j+1);
            visited[i][j+1] = false;
        }
        if ( j-1 >= 0 && !visited[i][j-1]) {
            visited[i][j-1] = true;
            dfs(cur + 1, sum + map[i][j-1] , i, j-1);
            visited[i][j-1] = false;

        }
            
    }
}
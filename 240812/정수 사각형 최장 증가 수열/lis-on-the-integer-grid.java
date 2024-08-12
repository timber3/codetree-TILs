import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, result = 1;
    static int[][] map, dp;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        dp = new int[n][n];

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0 ; j < n ; j ++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = 1;
            }
        }

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                search(i, j);
            }
        }

        System.out.println(result);
    }

    static void search(int x, int y) {
        for (int t = 0 ; t < 4 ; t ++) {
            int nx = x + dx[t];
            int ny = y + dy[t];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

            if (map[x][y] > map[nx][ny]) {
                int maxVal = Math.max(dp[nx][ny], dp[x][y] + 1);
                dp[nx][ny] = maxVal;
                result = Math.max(maxVal, result);
                search(nx, ny);
            }
        }
    }
}
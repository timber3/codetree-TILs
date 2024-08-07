import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, result = Integer.MIN_VALUE;
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
                
                for (int t = 0 ; t < 4 ; t ++) {
                    int nx = i + dx[t];
                    int ny = j + dy[t];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                    if (map[i][j] > map[nx][ny]) {
                        dp[i][j] = Math.max(dp[nx][ny] + 1, dp[i][j]);
                        result = Math.max(dp[i][j], result);
                    }
                }
            }
        }

        System.out.println(result);
    }
}
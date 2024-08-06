import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[][] map, dp;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];
        dp = new int[n+1][n+1];

        for (int i = 1 ; i <= n ; i ++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0 ; j < n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][n-1] = map[1][n-1];

        for (int i = n-2 ; i >= 0 ; i --) {
            dp[1][i] = dp[1][i+1] + map[1][i];
        }

        for (int i = 2 ; i <= n ; i ++) {
            dp[i][n-1] = dp[i-1][n-1] + map[i][n-1];
        }

        for (int i = 2 ; i <= n ; i++) {
            for (int j = n-2 ; j >= 0 ; j--) {
                dp[i][j] = Math.min(dp[i-1][j] + map[i][j], dp[i][j+1] + map[i][j]);
            }
        }

        System.out.println(dp[n][0]);

    }
}
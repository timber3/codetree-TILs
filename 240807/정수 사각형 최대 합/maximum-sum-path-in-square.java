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

            for (int j = 1 ; j <= n ; j ++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1 ; i <= n ; i ++) {
            for (int j = 1 ; j <= n ; j ++) {
                dp[i][j] = Math.max(dp[i-1][j] + map[i][j], dp[i][j-1] + map[i][j]);
            }
        }

        System.out.println(dp[n][n]);

    }
}
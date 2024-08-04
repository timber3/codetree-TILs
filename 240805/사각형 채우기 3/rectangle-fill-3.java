import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static long[] dp = new long[1001];

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 7;

        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 2] * 3) % 1_000_000_007;
            for(int j = i - 3; j >= 0; j--)
                dp[i] = (dp[i] + dp[j] * 2) % 1_000_000_007;
        }

        System.out.println(dp[n]);
    }
}
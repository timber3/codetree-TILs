import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] dp;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        dp = new int[n+1];

        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3 ; i <= n ; i ++) {
            dp[i] = (dp[i-1] + dp[i-2] * 2) % 10007;
        }

        System.out.println(dp[n]);
    }
}
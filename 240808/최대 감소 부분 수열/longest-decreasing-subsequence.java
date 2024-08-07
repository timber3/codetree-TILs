import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, result = 1;

    static int[] arr, dp;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        arr = new int[n];
        dp = new int[n];

        for (int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < i ; j++) {    // i보다 앞쪽에 있는 원소들 중 arr[i]보다 큰 값이 있다면, dp 배열 갱신
                if(arr[j] > arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }                    
            }
        }
 
        for(int i = 0 ; i < n ; i ++) {
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}
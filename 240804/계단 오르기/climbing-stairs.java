import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] arr;
    static int n;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        
        arr = new int[n+1];

        if (n >= 2)
            arr[2] = 1;
        if (n >= 3)
            arr[3] = 1;

        for (int i = 4 ; i <= n ; i ++) {
            arr[i] = (arr[i-2] + arr[i-3])%10007;
        }

        System.out.println(arr[n]);
    }
}
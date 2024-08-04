import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] arr = new int[1001];


    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;

        for (int i = 4 ; i <= n ; i ++) {
            arr[i] = (arr[i-2] + arr[i-1]) % 10007;
        }
        
        System.out.println(arr[n]);
    }
}
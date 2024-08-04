import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] arr = new int[46];

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        arr[1] = 1;
        arr[2] = 1;

        for (int i = 3 ; i <= n ; i ++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        System.out.println(arr[n]);
    }
}
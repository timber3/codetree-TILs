import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static char[] arr;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        int size = str.length();

        arr = new char[size];

        for (int i = 0 ; i < size ; i ++) {
            arr[i] = str.charAt(i);
        }

        for (int i = 0; i < size-1 ; i ++) {
            char temp = arr[size-1];
            
            for (int j = size-1 ; j > 0 ; j --) {
                arr[j] = arr[j-1];
            }
            arr[0] = temp;

            // for (int j = 0 ; j <= size -1 ; j ++) {
            //     System.out.print(arr[j]);
            // }
            // System.out.println();

            int count = 1;
            for (int j = 0 ; j < size - 1 ; j ++) {
                if (arr[j] == arr[j+1]) {
                    count ++;
                } else {
                    sb.append(arr[j]);
                    sb.append(count);
                    count = 1;
                }
            }
            if (count > 1) {
                sb.append(arr[0]);
                sb.append(count);
            }
            if (arr[size-1] != arr[size-2]) {
                sb.append(arr[size-1]);
                sb.append(1);
            }

            // System.out.println(sb);

            result = Math.min(result, sb.toString().length());

            sb = new StringBuilder();
        }
        
        System.out.println(result);

    }
}
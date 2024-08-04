import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        int size = str.length();
        boolean same = true;

        for (int i = 0 ; i < size-1 ; i ++) {
            if (str.charAt(i) != str.charAt(i+1)) {
                same = false;
                break;
            }
        }

        if (!same) {
            while(str.charAt(0) != str.charAt(size-1)) {
                str = str.charAt(size-1) + str.substring(0, size-1);
            }
        }

        int count = 1;
        for (int i = 0 ; i < size-1 ; i ++) {
            if (str.charAt(i) == str.charAt(i+1)) {
                count ++;
            } else {
                sb.append(str.charAt(i));
                sb.append(count);
                count = 1;
            }
        }
        if (same) {
            sb.append(str.charAt(0));
            sb.append(count);
        }

        if (str.charAt(size-1) != str.charAt(size-2)) {
            sb.append(str.charAt(size-1) + "" + 1);
        }
        
        System.out.println(sb.toString().length());
    }
}
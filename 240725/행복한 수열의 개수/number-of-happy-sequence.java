import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] map;
    static int n, m, sum;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n ; j ++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        horizontal();
        vertical();


        System.out.println(sum);

    }

    static void horizontal() {
        for (int t = 0 ; t < n ; t ++) {
            for (int i = 0 ; i <= n-m ; i ++) {
                boolean flag = true;
                for (int j = 0 ; j < m-1 ; j ++) {
                    if (map[t][i+j] != map[t][i+j+1]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    sum ++;
                    break;
                }
            }
        }
    }

    static void vertical() {
        for (int t = 0 ; t < n ; t ++) {
            for (int i = 0 ; i <= n-m ; i ++) {
                boolean flag = true;
                for (int j = 0 ; j < m-1 ; j ++) {
                    if (map[i+j][t] != map[i+j+1][t]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    sum ++;
                    break;
                }
            }
        }
    }

    
}
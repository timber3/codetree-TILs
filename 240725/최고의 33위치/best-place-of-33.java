import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] map;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.

        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for (int i = 0 ; i < n ; i ++) {
            st= new StringTokenizer(br.readLine());

            for (int j = 0 ; j < n ; j ++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0 ; i < n-2; i ++) {
            for (int j = 0 ; j < n-2; j++) {
                int sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j] + map[i+1][j+1] + map[i+1][j+2] + map[i+2][j] + map[i+2][j+1] + map[i+2][j+2];
                if (sum > result) {
                    result = sum;
                }
            }
        }

        System.out.println(result);
    }
}
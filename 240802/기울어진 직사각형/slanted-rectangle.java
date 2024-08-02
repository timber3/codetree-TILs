import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dx = {-1,-1,1,1};
    static int[] dy = {1,-1,-1,1};

    static int[][] map;
    static int n, result;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < n ; j ++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                for (int h = 1 ; h < n ; h ++) {
                    for (int w = 1 ; w < n ; w ++) {
                        // 만약 범위 안이라면
                        if (inRange(i, j, h, w)) {
                            // 값을 계산해서 갱신해주기
                            result = Math.max(getSum(i,j,h,w), result);
                        }
                    }
                }
            }
        }

        System.out.println(result);

    }

    static boolean inRange(int x, int y, int h, int w) {

        for(int i = 0 ; i < 4 ; i += 2) {
            int nx = x + dx[i] * h;
            int ny = y + dy[i] * h;

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) return false;

            x = nx;
            y = ny;

            nx = x + dx[i+1] * w;
            ny = y + dy[i+1] * w;

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) return false;

            x = nx;
            y = ny;
        }

        return true;
    }

    static int getSum(int x, int y, int h, int w) {
        int sum = 0;

        for(int i = 0 ; i < 4 ; i += 2) {
            for (int j = 0 ; j < h ; j ++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                sum += map[nx][ny];

                x = nx;
                y = ny;
            }

            for (int j = 0 ; j < w ; j ++) {
                int nx = x + dx[i+1];
                int ny = y + dy[i+1];

                sum += map[nx][ny];

                x = nx;
                y = ny;
            }
        }

        return sum;
    }
}
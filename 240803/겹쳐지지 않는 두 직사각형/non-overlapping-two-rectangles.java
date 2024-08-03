import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int result = Integer.MIN_VALUE;
    static int[][] map;

    static int[][] visited;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m];

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m ; j ++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int x1 = 0 ; x1 < n ; x1 ++) {
            for (int y1 = 0 ; y1 < m ; y1 ++) {
                for (int h1 = 1 ; h1 <= n ; h1 ++) {
                    for (int w1 = 1 ; w1 <= m ; w1 ++) {

                        // 1 직사각형이 범위 안에 있을 때
                        if (inRange(x1, y1, h1, w1)) {
                            for (int x2 = 0 ; x2 < n ; x2 ++) {
                                for (int y2 = 0 ; y2 < m ; y2 ++) {
                                    for (int h2 = 1 ; h2 <= n ; h2 ++) {
                                        for (int w2 = 1 ; w2 <= m ; w2 ++) {

                                            // 2 직사각형이 범위 안에 있을 때
                                            if (inRange(x2, y2, h2, w2)) {
                                                // 표시하다가 겹치면 종료
                                                if (check(x1, y1, h1, w1, x2, y2, h2, w2)){
                                                    result = Math.max(result, count());
                                                }

                                                visited = new int[n][m];
                                            }

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }

    static boolean inRange(int x, int y, int h, int w) {
        int nx = x + h - 1;
        int ny = y + w - 1;

        if (nx < 0 || ny < 0 || nx >= n || ny >=m ) return false;

        return true;
    }

    static boolean check(int x1, int y1, int h1, int w1, int x2, int y2, int h2, int w2) {
        for (int i = 0 ; i < h1 ; i ++) {
            for (int j = 0 ; j < w1 ; j ++) {
                visited[x1+i][y1+j] = 1;
            }
        }

        for (int i = 0 ; i < h2 ; i ++) {
            for (int j = 0 ; j < w2 ; j ++) {
                if (visited[x2+i][y2+j] != 0) {
                    return false;
                } else {
                    visited[x2+i][y2+j] = 2;
                }
            }
        }
        return true;
    }

    static int count () {
        int sum = 0;

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < m ; j ++) {
                if (visited[i][j] != 0) {
                    sum += map[i][j];
                }
            }
        }
        return sum;
    }

}
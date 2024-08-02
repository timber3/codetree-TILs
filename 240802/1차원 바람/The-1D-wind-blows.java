import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m, q;
    static int[][] map;
    static boolean[] blowed;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        blowed = new boolean[n];

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0 ; j < m ; j ++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0 ; i < q ; i ++) {
            st = new StringTokenizer(br.readLine());

            int row = Integer.parseInt(st.nextToken()) - 1;
            char dir = st.nextToken().charAt(0);

            windBlow(row, dir);
        }

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < m ; j ++) {
                System.out.printf("%d ", map[i][j]);
            }
            System.out.println();
        }

    }

    static void windBlow(int row, char dir) {
        blowed[row] = true;
        // 1. 밀기
        if (dir == 'L') {
            int temp = map[row][m-1];
            for (int i = m-1 ; i >= 1 ; i --) {
                map[row][i] = map[row][i-1];
            }
            map[row][0] = temp;
        } else {
            int temp = map[row][0];
            for (int i = 0 ; i < m-1 ; i ++) {
                map[row][i] = map[row][i+1];
            }
            map[row][m-1] = temp;
        }

        // 2. 위아래 확인해서 같으면 전파시키기
        for(int i = 0 ; i < n ; i ++) {
            // 위 행이 있고 바람이 분 적 없다면
            if (row > 0 && !blowed[row-1]) {
                // 각 열 비교
                for (int j = 0 ; j < m ; j ++) {
                    // 같은게 있다면
                    if (map[row][j] == map[row-1][j]) {
                        if (dir == 'L') {
                            windBlow(row-1, 'R');
                        } else {
                            windBlow(row-1, 'L');
                        }
                        break;
                    }
                }
            }

            // 아래 행이 있고 바람이 분 적 없다면
            if (row < n - 1 && !blowed[row+1]) {
                // 각 열 비교
                for (int j = 0 ; j < m ; j ++) {
                    // 같은게 있다면
                    if (map[row][j] == map[row+1][j]) {
                        if (dir == 'L') {
                            windBlow(row+1, 'R');
                        } else {
                            windBlow(row+1, 'L');
                        }
                        break;
                    }
                }
            }

        }
    }
}
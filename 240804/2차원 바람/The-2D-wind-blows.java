import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m, q;
    static int[][] map, tempResult;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m ; j ++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0 ; i < q ; i ++) {
            st = new StringTokenizer(br.readLine());
            // 좌 상단 우 하단 좌표임
            int x1 = Integer.parseInt(st.nextToken())-1;
            int y1 = Integer.parseInt(st.nextToken())-1;
            int x2 = Integer.parseInt(st.nextToken())-1;
            int y2 = Integer.parseInt(st.nextToken())-1;

            tempResult = new int[n][m];

            blow(x1, y1, x2, y2);
            average(x1, y1, x2, y2);
        }

        for (int i = 0 ; i < n ; i ++ ) {
            for (int j = 0 ; j < m ; j ++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void blow(int x1, int y1, int x2, int y2) {

        int temp = map[x1][y1];

        for (int i = x1 ; i < x2; i++) {
            map[i][y1] = map[i+1][y1];
        }
        for (int i = y1 ; i < y2; i++) {
            map[x2][i] = map[x2][i+1];
        }
        for (int i = x2 ; i > x1; i--) {
            map[i][y2] = map[i-1][y2];
        }
        for (int i = y2 ; i > y1; i--) {
            map[x1][i] = map[x1][i-1];
        }
        map[x1][y1+1] = temp;
    }

    static void average(int x1, int y1, int x2, int y2) {
        for (int i = x1 ; i <= x2 ; i ++) {
            for (int j = y1; j <= y2; j++) {
                int sum = map[i][j];
                int count = 1;
                
                for (int t = 0 ; t < 4 ; t ++) {
                    int nx = i + dx[t];
                    int ny = j + dy[t];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= m ) continue;

                    sum += map[nx][ny];
                    count ++;
                }

                int avg = sum / count;

                tempResult[i][j] = avg;
            }
        }


        for (int i = x1 ; i <= x2 ; i ++) {
            for (int j = y1 ; j <= y2 ; j ++) {
                map[i][j] = tempResult[i][j];
            }
        }
    }
}
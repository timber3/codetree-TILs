import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m, maxK, result;
    static int[][] map;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maxK = n + 2;

        map = new int[n][n];

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0 ; j < n ; j ++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    result = 1;
                }
            }
        }

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j ++) {

                // 마름모 모양으로 확인하기
                for (int k = 1 ; k <= maxK ; k++) {
                    bfs(k, i, j);
                }
            }
        }

        System.out.println(result);
    }

    static void bfs(int k, int x ,int y) {

        int[][] visited = new int[n][n];

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                visited[i][j] = -1;
            }
        }

        visited[x][y] = 0;

        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(x, y));

        while(!q.isEmpty()) {
            Node cur = q.pop();
            int cx = cur.x;
            int cy = cur.y;

            for (int i = 0 ; i < 4 ; i ++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny]>= 0) continue;

                if (visited[cx][cy] < k && visited[nx][ny] == -1) {
                    visited[nx][ny] = visited[cx][cy] + 1;
                    q.add(new Node(nx, ny));
                }
            }
        }

        int cost = k * k + (k + 1) * (k + 1);
        int gold = 0;
        // 지정된 공간 만큼 금 캐기
        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                if (visited[i][j] >= 0) {
                    if (map[i][j] == 1) {
                        gold ++;
                    }
                }
            }
        }

        if (gold > result && (gold * m) - cost > 0) {
            result = gold;
        }   
    }
}
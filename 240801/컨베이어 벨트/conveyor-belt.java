import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, t;
    static ArrayDeque<Integer> q1 = new ArrayDeque<>();
    static ArrayDeque<Integer> q2 = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i ++) {
            int v = Integer.parseInt(st.nextToken());
            q1.add(v);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i ++) {
            int v = Integer.parseInt(st.nextToken());
            q2.add(v);
        }

        for (int i = 0 ; i < t ; i ++) {
            q1.addFirst(q2.pollLast());
            q2.addFirst(q1.pollLast());
        }

        for (int i = 0 ; i < n ; i ++) {
            System.out.printf("%d ", q1.poll());
        }

        System.out.println();

        for (int i = 0 ; i < n ; i ++) {
            System.out.printf("%d ", q2.poll());
        }
    }
}
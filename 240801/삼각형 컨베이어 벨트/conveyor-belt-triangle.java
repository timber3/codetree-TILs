import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int t, n;
    static ArrayDeque<Integer> q1 = new ArrayDeque<>();
    static ArrayDeque<Integer> q2 = new ArrayDeque<>();
    static ArrayDeque<Integer> q3 = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i++ ) {
            q1.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i++ ) {
            q2.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i++ ) {
            q3.add(Integer.parseInt(st.nextToken()));
        }


        for (int i = 0 ; i < t ; i ++) {
            q1.addFirst(q3.pollLast());
            q2.addFirst(q1.pollLast());
            q3.addFirst(q2.pollLast());
        }

        for(int i = 0 ; i < 3 ; i ++) {
            System.out.printf("%d ", q1.poll());
        }
        System.out.println();
        for(int i = 0 ; i < 3 ; i ++) {
            System.out.printf("%d ", q2.poll());
        }
        System.out.println();
        for(int i = 0 ; i < 3 ; i ++) {
            System.out.printf("%d ", q3.poll());
        }
    }
}
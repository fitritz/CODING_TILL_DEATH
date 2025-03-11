import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

class KthLargestElementCheckpoint20 {

    static class Fs {
        private final Scanner sc = new Scanner(System.in);

        int nextInt() {
            return sc.nextInt();
        }

        String next() {
            return sc.next();
        }
    }

    public static void main(String[] args) throws IOException {
        Fs sc = new Fs();
        int n = sc.nextInt(), k = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (pq.size() < k) pq.offer(x);
            else if (x > pq.peek()) { pq.poll(); pq.offer(x); }
        }
        System.out.println(pq.peek());
    }

}

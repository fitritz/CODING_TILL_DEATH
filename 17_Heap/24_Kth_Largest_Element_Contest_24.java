import java.util.PriorityQueue;
import java.util.Scanner;

class KthLargestElementContest24 {

    static class FastIn {
        private final Scanner sc = new Scanner(System.in);

        int nextInt() {
            return sc.nextInt();
        }

        String next() {
            return sc.next();
        }
    }

    public static void main(String[] args) throws Exception {
        FastIn io = new FastIn();
        int n = io.nextInt(), k = io.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = io.nextInt();
            if (pq.size() < k) pq.offer(x);
            else if (x > pq.peek()) { pq.poll(); pq.offer(x); }
        }
        System.out.println(pq.peek());
    }

}

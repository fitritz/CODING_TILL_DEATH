import java.util.ArrayDeque;
import java.util.Scanner;

class SlidingWindowMaximumDrill18 {

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
        FastIn sc = new FastIn();
        int n = sc.nextInt(), k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();
            while (!dq.isEmpty() && a[dq.peekLast()] <= a[i]) dq.pollLast();
            dq.offerLast(i);
            if (i >= k - 1) { if (out.length() > 0) out.append(' '); out.append(a[dq.peekFirst()]); }
        }
        System.out.println(out);
    }

}

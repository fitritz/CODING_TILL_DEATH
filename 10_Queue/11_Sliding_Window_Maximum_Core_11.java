import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;

class SlidingWindowMaximumCore11 {

    static class In {
        private final InputStream in;
        private final byte[] buf = new byte[1 << 15];
        private int ptr = 0, len = 0;

        In(InputStream is) {
            in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buf);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buf[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do c = read(); while (c <= 32 && c != -1);
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = 0;
            while (c > 32) {
                val = val * 10 + c - '0';
                c = read();
            }
            return val * sign;
        }

        String next() throws IOException {
            int c;
            do c = read(); while (c <= 32 && c != -1);
            StringBuilder s = new StringBuilder();
            while (c > 32) {
                s.append((char) c);
                c = read();
            }
            return s.toString();
        }
    }

    public static void main(String[] args) throws Exception {
        In ip = new In(System.in);
        int n = ip.nextInt(), k = ip.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = ip.nextInt();
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

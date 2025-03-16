import java.io.IOException;
import java.io.InputStream;
import java.util.PriorityQueue;

class KthLargestElementRevision25 {

    static class InputFast {
        private final InputStream in;
        private final byte[] buf = new byte[1 << 15];
        private int ptr = 0, len = 0;

        InputFast(InputStream is) {
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

    public static void main(String[] args) throws IOException {
        InputFast fs = new InputFast(System.in);
        int n = fs.nextInt(), k = fs.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = fs.nextInt();
            if (pq.size() < k) pq.offer(x);
            else if (x > pq.peek()) { pq.poll(); pq.offer(x); }
        }
        System.out.println(pq.peek());
    }

}

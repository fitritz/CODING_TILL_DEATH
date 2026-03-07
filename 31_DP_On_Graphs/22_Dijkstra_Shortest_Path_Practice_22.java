import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class DijkstraShortestPathPractice22 {

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

    static class E { int to, w; E(int t, int w) { to = t; this.w = w; } }
    static class N { int v; long d; N(int v, long d) { this.v = v; this.d = d; } }
    public static void main(String[] args) throws Exception {
        In ip = new In(System.in);
        int n = ip.nextInt(), m = ip.nextInt(), src = ip.nextInt(), dst = ip.nextInt();
        List<List<E>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());
        for (int i = 0; i < m; i++) { int u = ip.nextInt(), v = ip.nextInt(), w = ip.nextInt(); g.get(u).add(new E(v, w)); g.get(v).add(new E(u, w)); }
        long[] d = new long[n + 1];
        Arrays.fill(d, Long.MAX_VALUE / 4);
        PriorityQueue<N> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.d));
        d[src] = 0; pq.offer(new N(src, 0));
        while (!pq.isEmpty()) {
            N c = pq.poll();
            if (c.d != d[c.v]) continue;
            for (E e : g.get(c.v)) {
                long nd = c.d + e.w;
                if (nd < d[e.to]) { d[e.to] = nd; pq.offer(new N(e.to, nd)); }
            }
        }
        System.out.println(d[dst] >= Long.MAX_VALUE / 8 ? -1 : d[dst]);
    }

}

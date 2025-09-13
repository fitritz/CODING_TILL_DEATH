import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class DijkstraShortestPathContest24 {

    static class TokenReader {
        private final BufferedInputStream in = new BufferedInputStream(System.in);
        private final byte[] data = new byte[1 << 16];
        private int idx = 0, size = 0;

        private int read() throws IOException {
            if (idx >= size) {
                size = in.read(data);
                idx = 0;
                if (size < 0) return -1;
            }
            return data[idx++];
        }

        int nextInt() throws IOException {
            int c;
            do c = read(); while (c <= 32 && c != -1);
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int x = 0;
            while (c > 32) {
                x = x * 10 + (c - '0');
                c = read();
            }
            return x * sign;
        }

        String next() throws IOException {
            int c;
            do c = read(); while (c <= 32 && c != -1);
            StringBuilder sb = new StringBuilder();
            while (c > 32) {
                sb.append((char) c);
                c = read();
            }
            return sb.toString();
        }
    }

    static class E { int to, w; E(int t, int w) { to = t; this.w = w; } }
    static class N { int v; long d; N(int v, long d) { this.v = v; this.d = d; } }
    public static void main(String[] args) throws IOException {
        TokenReader reader = new TokenReader();
        int n = reader.nextInt(), m = reader.nextInt(), src = reader.nextInt(), dst = reader.nextInt();
        List<List<E>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());
        for (int i = 0; i < m; i++) { int u = reader.nextInt(), v = reader.nextInt(), w = reader.nextInt(); g.get(u).add(new E(v, w)); g.get(v).add(new E(u, w)); }
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

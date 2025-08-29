import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class DijkstraShortestPathMastery09 {

    static class QuickReader {
        private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    static class E { int to, w; E(int t, int w) { to = t; this.w = w; } }
    static class N { int v; long d; N(int v, long d) { this.v = v; this.d = d; } }
    public static void main(String[] args) throws IOException {
        QuickReader input = new QuickReader();
        int n = input.nextInt(), m = input.nextInt(), src = input.nextInt(), dst = input.nextInt();
        List<List<E>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());
        for (int i = 0; i < m; i++) { int u = input.nextInt(), v = input.nextInt(), w = input.nextInt(); g.get(u).add(new E(v, w)); g.get(v).add(new E(u, w)); }
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

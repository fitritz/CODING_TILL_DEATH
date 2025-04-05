import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BFSShortestPathMastery19 {

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
        int n = ip.nextInt(), m = ip.nextInt(), src = ip.nextInt(), dst = ip.nextInt();
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());
        for (int i = 0; i < m; i++) { int u = ip.nextInt(), v = ip.nextInt(); g.get(u).add(v); g.get(v).add(u); }
        int[] d = new int[n + 1];
        Arrays.fill(d, -1);
        ArrayDeque<Integer> q = new ArrayDeque<>();
        d[src] = 0; q.offer(src);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g.get(u)) if (d[v] == -1) { d[v] = d[u] + 1; q.offer(v); }
        }
        System.out.println(d[dst]);
    }

}

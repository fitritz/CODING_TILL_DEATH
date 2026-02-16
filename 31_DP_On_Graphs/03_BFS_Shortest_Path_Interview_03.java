import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BFSShortestPathInterview03 {

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

    public static void main(String[] args) throws IOException {
        TokenReader in = new TokenReader();
        int n = in.nextInt(), m = in.nextInt(), src = in.nextInt(), dst = in.nextInt();
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());
        for (int i = 0; i < m; i++) { int u = in.nextInt(), v = in.nextInt(); g.get(u).add(v); g.get(v).add(u); }
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

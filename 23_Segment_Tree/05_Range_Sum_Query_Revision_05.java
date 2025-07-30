import java.io.IOException;
import java.io.InputStream;

class RangeSumQueryRevision05 {

    static class FastScanner {
        private final InputStream in;
        private final byte[] buf = new byte[1 << 15];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
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

    static class ST {
        long[] t; int n;
        ST(int[] a) { n = a.length; t = new long[4 * n]; b(1, 0, n - 1, a); }
        void b(int v, int l, int r, int[] a) {
            if (l == r) { t[v] = a[l]; return; }
            int m = (l + r) >>> 1;
            b(v << 1, l, m, a); b(v << 1 | 1, m + 1, r, a);
            t[v] = t[v << 1] + t[v << 1 | 1];
        }
        long q(int v, int l, int r, int L, int R) {
            if (L > r || R < l) return 0;
            if (L <= l && r <= R) return t[v];
            int m = (l + r) >>> 1;
            return q(v << 1, l, m, L, R) + q(v << 1 | 1, m + 1, r, L, R);
        }
    }
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt(), q = fs.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = fs.nextInt();
        ST st = new ST(a);
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < q; i++) out.append(st.q(1, 0, n - 1, fs.nextInt(), fs.nextInt())).append('\n');
        System.out.print(out);
    }

}
